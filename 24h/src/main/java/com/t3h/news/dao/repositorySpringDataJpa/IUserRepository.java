package com.t3h.news.dao.repositorySpringDataJpa;

import com.t3h.news.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity,Integer> {

    UserEntity findByUsername(String username);

    @Query("SELECT E FROM UserEntity E  WHERE E.fullName like :fullName")
    List<UserEntity> findByFullName(@Param("fullName") String fullName);

    @Query(value = "SELECT * from user inner join role_user on user.id = role_user.user_id " +
            "inner join role on role.id = role_user.role_id" +
            "where role.name = :roleName",nativeQuery = true)
    List<UserEntity> findByRoleName(String roleName);
}
