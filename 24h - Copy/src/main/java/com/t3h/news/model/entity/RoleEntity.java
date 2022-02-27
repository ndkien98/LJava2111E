package com.t3h.news.model.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "role")
public class RoleEntity extends BaseEntity{

    private String name;

    @ManyToMany(mappedBy = "setRole",fetch = FetchType.LAZY)
    private Set<UserEntity> setUser = new HashSet<>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<UserEntity> getSetUser() {
        return setUser;
    }

    public void setSetUser(Set<UserEntity> setUser) {
        this.setUser = setUser;
    }
}
