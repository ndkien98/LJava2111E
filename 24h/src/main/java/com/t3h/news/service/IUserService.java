package com.t3h.news.service;

import com.t3h.news.model.UserModel;
import com.t3h.news.model.entity.UserEntity;
import com.t3h.news.model.response.SystemResponse;

import java.util.List;

public interface IUserService {

    SystemResponse<List<UserModel>> getAll();

    SystemResponse<UserModel> add(UserModel userModel);

    SystemResponse<UserModel> findById(int id);

    SystemResponse<List<UserModel>> findByFullName(String fullName);

    SystemResponse<List<UserModel>> findByRoleName(String roleName);
}
