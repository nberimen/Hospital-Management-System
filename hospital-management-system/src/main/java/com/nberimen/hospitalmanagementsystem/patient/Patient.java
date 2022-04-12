package com.nberimen.hospitalmanagementsystem.patient;

import com.nberimen.hospitalmanagementsystem.user.User;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "PATIENT")
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
public class Patient extends User {

    @Column(name = "FIRST_NAME", length = 50, nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", length = 50, nullable = false)
    private String lastName;

}
