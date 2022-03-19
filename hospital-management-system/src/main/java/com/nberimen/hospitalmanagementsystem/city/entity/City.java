package com.nberimen.hospitalmanagementsystem.city.entity;

import com.nberimen.hospitalmanagementsystem.gen.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "CITY")
@Data
public class City extends BaseEntity {

    @Id
    @SequenceGenerator(name = "City", sequenceName = "CITY_ID_SEQ")
    @GeneratedValue(generator = "City")
    private Long id;

    @Column(name = "NAME", nullable = false, length = 30)
    private String name;
}
