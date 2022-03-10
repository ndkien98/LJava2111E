package com.t3h.newspringboot.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Table(name = "NEW")
@Entity
public class NewsEntity extends BaseEntity{

    private String title;

    @Column(columnDefinition = "text")
    private String content;

    private String avatar;

    private String author;

    @Column
    private Integer categoryId;

    private String originalResource;

    private Integer numberAccess;

    private Integer censor;
}
