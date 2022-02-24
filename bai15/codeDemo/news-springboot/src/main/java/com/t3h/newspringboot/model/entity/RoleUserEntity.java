package model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "ROLE_USER")
@Entity
public class RoleUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int userId;

    private int roleId;
}
