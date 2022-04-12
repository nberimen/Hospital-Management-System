package com.nberimen.hospitalmanagementsystem.department;


import com.nberimen.hospitalmanagementsystem.gen.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "DEPARTMENTS")
@Data
public class Department extends BaseEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ID_HOSPITAL", nullable = false)
    private Long hospitalId;

    @Column(name = "NAME", nullable = false, length = 50)
    private String name;



}
