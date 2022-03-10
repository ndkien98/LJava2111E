package com.t3h.newspringboot.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewsRequest {

    private int id;

    private String title;

    private String content;

    private String avatar;

    private String author;

    private int categoryId;

    private String originalResource;

    private int numberAccess;

    private int censor;


}
