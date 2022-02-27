package com.t3h.news.model.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Table(name = "category")
@Entity
public class CategoryEntity extends BaseEntity{

    private String name;

    @OneToMany(mappedBy = "category")
    private Set<NewsEntity> news;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<NewsEntity> getNews() {
        return news;
    }

    public void setNews(Set<NewsEntity> news) {
        this.news = news;
    }
}
