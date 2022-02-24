package model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "ROLE")
@Entity
public class RoleEntity extends BaseEntity{

    private int name;

}
