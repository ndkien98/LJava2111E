package com.t3h.news.model;


import javax.persistence.*;
import java.sql.Timestamp;

public class NewsModel {

    private Integer id;

    private String title;

    private String content;

    private Timestamp createdDate;

    private Timestamp updateDate;

    private String avatar;

    private int creatorId;

    private int editorId;

    private String author = "";

    private int categoryId;

    private String originalResource;

    private int numberAccess;

    private int censor;

    private String categoryName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }

    public int getEditorId() {
        return editorId;
    }

    public void setEditorId(int editorId) {
        this.editorId = editorId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
