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
@Table(name = "aeroporto")
public class AeroportoEntity {
    private String nome;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "aeroporto_id", nullable = false)
    private Long id;
    @OneToOne
    @JoinColumn(name = "refgeo_id")
    private RefGeoEntity localizacao;

}
