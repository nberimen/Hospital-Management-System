package com.nberimen.hospitalmanagementsystem.doctor;

import com.nberimen.hospitalmanagementsystem.user.User;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "DOCTOR")
@Data
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
public class Doctor extends User {

    @Column(name = "FIRST_NAME", length = 50, nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", length = 50, nullable = false)
    private String lastName;

    @Column(name = "ID_DEPARTMENT", nullable = false)
    private Long departmentId;

}
