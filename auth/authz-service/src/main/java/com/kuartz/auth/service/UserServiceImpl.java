package com.kuartz.auth.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.kuartz.auth.builder.UserQueryBuilder;
import com.kuartz.auth.entity.RoleEntity;
import com.kuartz.auth.entity.UserEntity;
import com.kuartz.auth.entity.UserRoleEntity;
import com.kuartz.auth.entity.query.UserEntityQuery;
import com.kuartz.auth.repository.UserRepository;
import com.kuartz.core.auth.dto.RegisterModel;
import com.kuartz.core.auth.dto.RoleModel;
import com.kuartz.core.auth.dto.UserModel;
import com.kuartz.core.auth.dto.query.UserQueryModel;
import com.kuartz.core.common.converter.KuartzModelConverter;
import com.kuartz.core.common.domain.KzPage;
import com.kuartz.core.common.exception.ExceptionMessage;
import com.kuartz.core.common.exception.KzException;
import com.kuartz.core.common.util.KzUtil;
import com.kuartz.core.data.jpa.TransactionalRollback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@TransactionalRollback
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserQueryBuilder queryBuilder;

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntityQuery entityQ = UserEntityQuery.userEntity;
        Optional<UserEntity> user = userRepository.findOne(entityQ.username.eq(username).or(entityQ.email.eq(username)));

        if (user.isPresent()) {
            return user.get();
        } else {
            throw new UsernameNotFoundException("Username not found!"); // TODO: @kutay-celebi 17.03.2020 move message bundle
        }
    }

    @Override
    public UserModel register(RegisterModel registerModel) throws KzException {

        UserEntityQuery entityQ = UserEntityQuery.userEntity;
        boolean exists = userRepository.exists(
                entityQ.username.eq(registerModel.getUsername()).or(entityQ.email.eq(registerModel.getEmail())));

        if (exists) {
            throw new KzException(new ExceptionMessage("auth_user_usernameEmailExists", UserServiceImpl.class));
        }
        UserEntity entity = KuartzModelConverter.convert(registerModel, UserEntity.class);
        entity.setPassword(passwordEncoder.encode(registerModel.getPassword()));

        List<RoleModel> varsayilanRolList = roleService.getDefaultRoleList();


        if (KzUtil.isEmpty(entity.getRoleList())) {
            entity.setRoleList(new ArrayList<>());
        }
        UserEntity finalEntity = entity;
        varsayilanRolList.forEach(r -> {
            finalEntity.getRoleList().add(new UserRoleEntity(finalEntity, KuartzModelConverter.convert(r, RoleEntity.class)));
        });

        entity = userRepository.saveFlush(finalEntity);
        return KuartzModelConverter.convert(entity, UserModel.class);
    }

    @Transactional(readOnly = true)
    @Override
    public UserModel getUserByUsernameOrEmail(String usernameOrEmail) {
        Optional<UserEntity> one = userRepository.findOne(
                UserEntityQuery.userEntity.username.eq(usernameOrEmail).or(UserEntityQuery.userEntity.email.eq(usernameOrEmail)));
        return KuartzModelConverter.convert(one.orElseGet(null), UserModel.class);
    }

    @Override
    public KzPage<UserModel> getPage(UserQueryModel queryModel) {
        KzPage<UserEntity> page = userRepository.findAll(queryBuilder.buildQuery(queryModel, UserEntityQuery.userEntity),
                                                         queryModel.getPageable());
        return KuartzModelConverter.convert(page, new TypeReference<KzPage<UserModel>>() {
        });
    }

    @Override
    public UserModel add(UserModel user) {
        UserEntity entity = KuartzModelConverter.convert(user, UserEntity.class);
        if (entity.getId() == null) { // TODO: @kutay-celebi 20.03.2020 move core
            entity.setPassword(passwordEncoder.encode("123")); // FIXME: @kutay-celebi 18.03.2020

            List<RoleModel> varsayilanRolList = roleService.getDefaultRoleList();
            if (KzUtil.isEmpty(entity.getRoleList())) {
                entity.setRoleList(new ArrayList<>());
            }

            varsayilanRolList.forEach(r -> {
                entity.getRoleList().add(new UserRoleEntity(entity, KuartzModelConverter.convert(r, RoleEntity.class)));
            });

        }
        UserEntity saved = userRepository.saveFlush(entity);
        return KuartzModelConverter.convert(saved, UserModel.class);
    }

}
