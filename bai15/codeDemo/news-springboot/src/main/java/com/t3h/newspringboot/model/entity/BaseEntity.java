package model.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Timestamp createDate;

    private Timestamp updateDate;

    @Column(nullable = true)
    private int creatorId;

    @Column(nullable = true)
    private int editorId;
}
