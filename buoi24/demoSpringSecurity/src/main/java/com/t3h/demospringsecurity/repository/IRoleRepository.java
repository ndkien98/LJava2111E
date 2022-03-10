package com.t3h.demospringsecurity.repository;

import com.t3h.demospringsecurity.model.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IRoleRepository extends JpaRepository<RoleEntity,Integer> {

    @Query(value = "select * from role join user_role ur on role.id = ur.role_id\n" +
            "where ur.user_id = :userId",nativeQuery = true)
    List<RoleEntity> getByUserId(Integer userId);
}
