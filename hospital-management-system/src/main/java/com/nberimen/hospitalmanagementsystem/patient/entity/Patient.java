package com.nberimen.hospitalmanagementsystem.patient.entity;

import com.nberimen.hospitalmanagementsystem.gen.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "PATIENT")
public class Patient extends BaseEntity {

    @Id
    @GeneratedValue(generator = "Patient")
    @SequenceGenerator(name = "Patient", sequenceName = "PATIENT_ID_SEQ")
    private Long id;

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

    @Column(name = "IDENTITY_NO")
    private Long identityNo;
}
