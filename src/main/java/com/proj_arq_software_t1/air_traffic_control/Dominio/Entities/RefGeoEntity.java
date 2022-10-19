package com.proj_arq_software_t1.air_traffic_control.Dominio.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "refgeo")
public class RefGeoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "refgeo_id", nullable = false)
    private Long id;
    private String nome;
    private double latitude;
    private double longitude;
}
