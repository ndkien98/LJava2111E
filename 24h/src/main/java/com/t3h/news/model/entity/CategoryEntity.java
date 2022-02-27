package com.t3h.news.model.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Table(name = "category")
@Entity
public class CategoryEntity extends BaseEntity {

    private String name;

    @OneToMany(mappedBy = "category")
    private Set<NewsEntity> newsEntities = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<NewsEntity> getNewsEntities() {
        return newsEntities;
    }

    public void setNewsEntities(Set<NewsEntity> newsEntities) {
        this.newsEntities = newsEntities;
    }
}
