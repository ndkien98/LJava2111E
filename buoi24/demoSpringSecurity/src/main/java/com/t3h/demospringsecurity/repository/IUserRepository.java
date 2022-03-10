package com.t3h.demospringsecurity.repository;

import com.t3h.demospringsecurity.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UserEntity,Integer> {

    UserEntity findByUsername(String username);

}
