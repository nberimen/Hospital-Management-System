package com.nberimen.hospitalmanagementsystem.doctor.entity;

import com.nberimen.hospitalmanagementsystem.gen.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "DOCTOR")
@Data
public class Doctor extends BaseEntity {

    @Id
    @GeneratedValue(generator = "Doctor")
    @SequenceGenerator(name = "Doctor", sequenceName = "DOCTOR_ID_SEQ")
    private Long id;

    @Column(name = "ID_HOSPITAL", nullable = false)
    private Long hospitalId;

    @Column(name = "FIRST_NAME", length = 50, nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", length = 50, nullable = false)
    private String lastName;

    @Column(name = "EMAIL", length = 100, nullable = false, unique = true)
    private String email;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "PHONE_NUMBER", nullable = false)
    private String phoneNumber;

    @Column(name = "BRANCH", nullable = false)
    private String branch;



}
