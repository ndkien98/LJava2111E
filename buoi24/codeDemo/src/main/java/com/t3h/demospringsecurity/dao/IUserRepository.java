package com.t3h.demospringsecurity.dao;

import com.t3h.demospringsecurity.model.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<AppUser,Integer> {

    AppUser findByUserName(String username);
}
