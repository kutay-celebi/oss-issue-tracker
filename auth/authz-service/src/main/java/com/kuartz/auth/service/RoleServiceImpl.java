package com.kuartz.auth.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.kuartz.auth.builder.RoleQueryBuilder;
import com.kuartz.auth.entity.PrivilegeEntity;
import com.kuartz.auth.entity.RoleEntity;
import com.kuartz.auth.entity.RolePrivilegeEntity;
import com.kuartz.auth.entity.query.RoleEntityQuery;
import com.kuartz.auth.repository.PrivilegeRepository;
import com.kuartz.auth.repository.RoleRepository;
import com.kuartz.core.auth.dto.RoleModel;
import com.kuartz.core.auth.dto.query.RoleQueryModel;
import com.kuartz.core.common.converter.KuartzModelConverter;
import com.kuartz.core.common.domain.KzPage;
import com.kuartz.core.data.jpa.TransactionalRollback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@TransactionalRollback
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository repository;

    @Autowired
    private PrivilegeRepository privilegeRepository;

    @Autowired
    private RoleQueryBuilder queryBuilder;

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
    public Boolean delete(Long id) {
        repository.deleteById(id);
        return Boolean.TRUE;
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
    public Boolean addPrivilege(Long roleId, Long privilegeId) {
        Optional<RoleEntity> roleOne = repository.findById(roleId);
        Optional<PrivilegeEntity> yetkiOne = privilegeRepository.findById(privilegeId);
        RoleEntity roleEntity = null;
        if (roleOne.isPresent() && yetkiOne.isPresent()) {
            roleEntity = roleOne.get();
            roleEntity.getRolePrivilegeRelationList().add(new RolePrivilegeEntity(yetkiOne.get(), roleOne.get()));
        }

        repository.saveFlush(roleEntity);

        return Boolean.TRUE;
    }
}
