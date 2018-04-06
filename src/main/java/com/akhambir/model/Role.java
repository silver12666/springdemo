package com.akhambir.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import static javax.persistence.EnumType.STRING;

@Data
@Entity
@Table(name = "ROLES")
public class Role {

    @Id
    @GeneratedValue(generator = "ROLE_GEN")
    @SequenceGenerator(name = "ROLE_GEN", sequenceName = "ROLE_SEQ", allocationSize = 1)
    private Long id;
    @Enumerated(STRING)
    @Column(name = "ROLE_NAME")
    private RoleName roleName;


    public Role() { }

    public enum RoleName {
        USER,
        MODERATOR,
        ADMIN
    }
}
