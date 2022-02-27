package com.t3h.news.dao.repositorySpringDataJpa;

import com.t3h.news.model.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<RoleEntity,Integer> {
}
