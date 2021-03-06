package com.kuartz.api.auth.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.kuartz.api.auth.builder.PrivilegeQueryBuilder;
import com.kuartz.api.auth.builder.RoleQueryBuilder;
import com.kuartz.api.auth.dto.RoleModel;
import com.kuartz.api.auth.dto.query.PrivilegeQueryModel;
import com.kuartz.api.auth.dto.query.RoleQueryModel;
import com.kuartz.api.auth.entity.PrivilegeEntity;
import com.kuartz.api.auth.entity.RoleEntity;
import com.kuartz.api.auth.entity.RolePrivilegeEntity;
import com.kuartz.api.auth.entity.query.PrivilegeEntityQuery;
import com.kuartz.api.auth.entity.query.RoleEntityQuery;
import com.kuartz.api.auth.repository.PrivilegeRepository;
import com.kuartz.api.auth.repository.RolePrivilegeRepository;
import com.kuartz.api.auth.repository.RoleRepository;
import com.kuartz.core.common.converter.KuartzModelConverter;
import com.kuartz.core.common.domain.KzPage;
import com.kuartz.core.common.model.KzMessageModel;
import com.kuartz.core.common.util.KzUtil;
import com.kuartz.core.data.jpa.TransactionalRollback;
import com.kuartz.core.env.KuartzMessageSource;
import com.kuartz.core.service.AbstractKuartzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@TransactionalRollback
public class RoleServiceImpl extends AbstractKuartzService implements RoleService {

    @Autowired
    private RoleRepository repository;

    @Autowired
    private PrivilegeRepository privilegeRepository;

    @Autowired
    private RoleQueryBuilder queryBuilder;

    @Autowired
    private PrivilegeQueryBuilder privilegeQueryBuilder;

    @Autowired
    private RolePrivilegeRepository rolePrivilegeRepository;

    @Autowired
    private KuartzMessageSource messageSource;


    @Transactional(readOnly = true)
    @Override
    public List<RoleModel> getDefaultRoleList() {
        RoleEntityQuery entityQ = RoleEntityQuery.roleEntity;
        return KuartzModelConverter.convert(repository.findAll(entityQ.defaultRole.isTrue()), new TypeReference<List<RoleModel>>() {
        });
    }

    @Transactional(readOnly = true)
    @Override
    public KzPage<RoleModel> getPage(RoleQueryModel queryModel) {
        KzPage<RoleEntity> rolePage = repository.findAll(queryBuilder.buildQuery(queryModel, RoleEntityQuery.roleEntity),
                                                         queryModel.getPageable());
        return KuartzModelConverter.convert(rolePage, new TypeReference<KzPage<RoleModel>>() {
        });
    }

    @Override
    public KzMessageModel delete(Long id) {
        repository.deleteById(id);
        return KzMessageModel.succeed().addMessage(getMessage("delete_success", 1));
    }

    @Override
    public RoleModel save(RoleModel roleModel) {
        RoleEntity kayitEdilen = repository.saveFlush(KuartzModelConverter.convert(roleModel, RoleEntity.class));
        return KuartzModelConverter.convert(kayitEdilen, RoleModel.class);
    }

    @Override
    public RoleModel update(RoleModel roleModel) {
        RoleEntity guncellenen = repository.updateFlush(KuartzModelConverter.convert(roleModel, RoleEntity.class));
        return KuartzModelConverter.convert(guncellenen, RoleModel.class);
    }

    @Transactional(readOnly = true)
    @Override
    public RoleModel get(Long id) {
        return KuartzModelConverter.convert(repository.findById(id).get(), RoleModel.class);
    }

    @Override
    public KzMessageModel addPrivilege(Long roleId, List<Long> privilegeId) {
        Optional<RoleEntity> roleOne = repository.findById(roleId);
        List<PrivilegeEntity> yetkiList = privilegeRepository.findAll(privilegeQueryBuilder.buildQuery(new PrivilegeQueryModel(privilegeId),
                                                                                                       PrivilegeEntityQuery.privilegeEntity));
        List<RolePrivilegeEntity> savedEntity = new ArrayList<>();
        if (roleOne.isPresent() && !KzUtil.isEmpty(yetkiList)) {
            ArrayList<RolePrivilegeEntity> relationList = new ArrayList<>();
            for (PrivilegeEntity privilegeEntity : yetkiList) {
                relationList.add(new RolePrivilegeEntity(privilegeEntity, roleOne.get()));
            }
            savedEntity = rolePrivilegeRepository.saveAllFlush(relationList);
        }
        return KzMessageModel.succeed().addMessage(getMessage("rowEffect", savedEntity.size()));
    }

    @Override
    public KzMessageModel removePrivilegeFromRole(Long relationId) {
        rolePrivilegeRepository.deleteById(relationId);
        return KzMessageModel.succeed().addMessage(getMessage("delete_success", 1));
    }
}
