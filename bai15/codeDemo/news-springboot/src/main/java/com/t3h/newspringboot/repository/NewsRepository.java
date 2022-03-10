package com.t3h.newspringboot.repository;

import com.t3h.newspringboot.model.entity.NewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface NewsRepository extends JpaRepository<NewsEntity,Integer> {

    @Query("SELECT N FROM NewsEntity N WHERE N.author like :author")
    List<NewsEntity> findByAuthor(@Param(value = "author") String author);

    @Query(value = "select * from NEWS where numberAccess = :numberAccess",nativeQuery = true)
    List<NewsEntity> findByNumberAccess(@Param(value = "numberAccess") Integer numberAccess);
}
