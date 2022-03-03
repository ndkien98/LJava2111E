package com.t3h.demospringsecurity.dao;

import com.t3h.demospringsecurity.model.entity.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IRoleRepository extends JpaRepository<AppRole,Integer> {


    @Query(value = "select app_role.role_name from app_role join user_role ur on app_role.role_id = ur.role_id\n" +
            "where user_id = :userId",nativeQuery = true)
    List<String> findRoleNamesByUserId(Long userId);
}
