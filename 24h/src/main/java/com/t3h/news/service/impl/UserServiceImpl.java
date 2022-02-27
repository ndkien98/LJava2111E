package com.t3h.news.service.impl;

import com.t3h.news.dao.repositorySpringDataJpa.IRoleRepository;
import com.t3h.news.dao.repositorySpringDataJpa.IUserRepository;
import com.t3h.news.model.RoleModel;
import com.t3h.news.model.UserModel;
import com.t3h.news.model.entity.RoleEntity;
import com.t3h.news.model.entity.UserEntity;
import com.t3h.news.model.response.SystemResponse;
import com.t3h.news.service.IUserService;
import com.t3h.news.utils.Constant;
import com.t3h.news.utils.HttpStatusCode;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;
    private final IRoleRepository iRoleRepository;

    private final ModelMapper modelMapper;

    public UserServiceImpl(IUserRepository userRepository, IRoleRepository iRoleRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.iRoleRepository = iRoleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public SystemResponse<List<UserModel>> getAll() {
        List<UserModel> userModels =  userRepository.findAll().stream()
                .map(entity -> {
                    UserModel userModel = modelMapper.map(entity,UserModel.class);
                    List<RoleModel> roleModels = entity.getRoleEntitySet().stream().map(roleEntity -> modelMapper.map(roleEntity,RoleModel.class)).collect(Collectors.toList());
                    userModel.setRoleModels(roleModels);
                    return userModel;
                })
                .collect(Collectors.toList());

        return new SystemResponse<>(HttpStatusCode.OK, Constant.SUCCESS,userModels);
    }

    @Override
    public SystemResponse<UserModel> add(UserModel userModel) {

        UserEntity userEntity = convertModelToEntity(userModel);
        userEntity = userRepository.save(userEntity);
        userModel.setId(userEntity.getId());
        return new SystemResponse<>(HttpStatusCode.OK,Constant.SUCCESS,userModel);
    }


    @Override
    public SystemResponse<UserModel> findById(int id) {
        UserEntity userEntity = userRepository.findById(id).orElse(new UserEntity());
        UserModel userModel = convertEntityToModel(userEntity);
        return new SystemResponse<>(HttpStatusCode.OK,Constant.SUCCESS,userModel);
    }


    @Override
    public SystemResponse<List<UserModel>> findByFullName(String fullName) {

        List<UserEntity> userEntities = userRepository.findByFullName("%"+ fullName + "%");
        List<UserModel> userModels = userEntities.stream().map(this::convertEntityToModel).collect(Collectors.toList());
        return new SystemResponse<>(HttpStatusCode.OK,Constant.SUCCESS,userModels);
    }

    @Override
    public SystemResponse<List<UserModel>> findByRoleName(String roleName) {
        List<UserEntity> userEntities = userRepository.findByRoleName(roleName);
        List<UserModel> userModels =  userEntities.stream().map(this::convertEntityToModel).collect(Collectors.toList());
        return new SystemResponse<>(HttpStatusCode.OK,Constant.SUCCESS,userModels);
    }

    private UserModel convertEntityToModel(UserEntity userEntity) {
        UserModel userModel = modelMapper.map(userEntity,UserModel.class);

        List<RoleModel> roleModels = userModel.getRoleModels().stream().map(roleEntity -> modelMapper.map(roleEntity,RoleModel.class)).collect(Collectors.toList());
        userModel.setRoleModels(roleModels);
        return userModel;
    }
    private UserEntity convertModelToEntity(UserModel userModel) {
        UserEntity userEntity = modelMapper.map(userModel,UserEntity.class);
        Set<RoleEntity> roleEntitySet = userModel.getRoleModels().stream().map(roleModel -> iRoleRepository.getById(roleModel.getId())).collect(Collectors.toSet());
        userEntity.setRoleEntitySet(roleEntitySet);
        return userEntity;
    }
}
