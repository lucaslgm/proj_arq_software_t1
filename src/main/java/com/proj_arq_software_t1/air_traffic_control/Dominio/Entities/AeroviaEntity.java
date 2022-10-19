package com.proj_arq_software_t1.air_traffic_control.Dominio.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "aerovia")
public class AeroviaEntity {

    private static final int ALTITUDE_MINIMA = 25000;
    private static final int ALTITUDE_MAXIMA = 3500;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "aerovia_id", nullable = false)
    private Long id;

    @OneToMany
    @JoinColumn(name = "faixa_id")
    private final List<FaixaAeroviaEntity> faixas = new ArrayList<>(10);
    private String nome;
    @OneToOne
    @JoinColumn(name = "refgeo_id")
    private RefGeoEntity origem;
    @OneToOne
    @JoinColumn(name = "refgeo_id")
    private RefGeoEntity destino;
    private int distancia;
    private Date data;
}
