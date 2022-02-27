package com.t3h.news.model.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * ORM:
 *
 */
@Entity
@Table(name = "news")
public class NewsEntity extends BaseEntity {

    @Column()
    private String title;

    @Column(columnDefinition = "text")
    private String content;

    private String avatar;

    private String author;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private CategoryEntity category;

    private String originalResource;

    private int numberAccess;

    private int censor;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public String getOriginalResource() {
        return originalResource;
    }

    public void setOriginalResource(String originalResource) {
        this.originalResource = originalResource;
    }

    public int getNumberAccess() {
        return numberAccess;
    }

    public void setNumberAccess(int numberAccess) {
        this.numberAccess = numberAccess;
    }

    public int getCensor() {
        return censor;
    }

    public void setCensor(int censor) {
        this.censor = censor;
    }
}
