package com.myProperty.Property_Manageent.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="PROPERTY_TABLE")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class PropertyEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "PROERTY_TABLE", nullable = false)
    private String title;
    private String description;
    private Double price;
    private String address;
}
