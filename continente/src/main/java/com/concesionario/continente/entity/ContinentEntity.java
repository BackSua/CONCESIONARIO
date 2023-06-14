package com.concesionario.continente.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Continent")
public class ContinentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "continent_id")
    private Long id;
    @Column(name = "continent_code", nullable = false, length = 12)
    private String code;
    @Column(name = "continent_description", nullable = false, length = 35)
    private String description;
    @Column(name = "continent_status", nullable = false)
    private String status;
}
