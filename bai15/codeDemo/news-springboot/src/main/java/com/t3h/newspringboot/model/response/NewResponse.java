package com.t3h.newspringboot.model.response;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class NewResponse {

    private Integer id;

    private Timestamp createDate;

    private Timestamp updateDate;

    private int creatorId;

    private int editorId;

    private String title;

    private String content;

    private String avatar;

    private String author;

    private int categoryId;

    private String originalResource;

    private int numberAccess;

    private int censor;
}
