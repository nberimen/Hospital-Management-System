package com.nberimen.hospitalmanagementsystem.hospital.entity;

import com.nberimen.hospitalmanagementsystem.gen.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "HOSPITAL")
@Data
public class Hospital extends BaseEntity {

    @Id
    @SequenceGenerator(name = "Hospital", sequenceName = "HOSPITAL_ID_SEQ")
    @GeneratedValue(generator = "Hospital")
    private Long id;

    @Column(name = "ID_CITY", nullable = false)
    private Long cityId;

    @Column(name = "NAME", nullable = false, length = 50)
    private String name;
}
