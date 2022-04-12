package com.nberimen.hospitalmanagementsystem.user;

import com.nberimen.hospitalmanagementsystem.gen.entity.BaseEntity;
import com.nberimen.hospitalmanagementsystem.user.enums.Role;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class User extends BaseEntity {

    @Column(name = "IDENTITY_NO")
    private Long identityNo;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name="ROLE")
    @Enumerated(EnumType.STRING)
    private Role role;
}
