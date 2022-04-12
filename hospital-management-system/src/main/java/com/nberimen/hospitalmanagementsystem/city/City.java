package com.nberimen.hospitalmanagementsystem.city;

import com.nberimen.hospitalmanagementsystem.gen.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "CITY")
@Data
public class City extends BaseEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", nullable = false, length = 30)
    private String name;
}
