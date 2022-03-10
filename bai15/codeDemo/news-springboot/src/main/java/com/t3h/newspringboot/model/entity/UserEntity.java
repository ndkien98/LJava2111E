package com.t3h.newspringboot.model.entity;

import lombok.Data;

import javax.persistence.Table;

@Data
@Table(name = "USER")
public class UserEntity extends BaseEntity{

    private String username;

    private String password;

    private String fullName;

    private String address;

    private String email;
}
