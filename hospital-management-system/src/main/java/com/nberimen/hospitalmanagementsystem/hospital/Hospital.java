package com.nberimen.hospitalmanagementsystem.hospital;

import com.nberimen.hospitalmanagementsystem.gen.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "HOSPITAL")
@Data
public class Hospital extends BaseEntity {
    @Column(name = "ID_CITY", nullable = false)
    private Long cityId;

    @Column(name = "NAME", nullable = false, length = 50)
    private String name;
}
