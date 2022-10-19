package com.proj_arq_software_t1.air_traffic_control.Dominio.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rota")
public class RotaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rota_id", nullable = false)
    private Long id;
    @OneToOne
    private AeroportoEntity origem;
    @OneToOne
    private AeroportoEntity destino;
    @OneToMany
    private List<AeroviaEntity> conjuntoAeroviaEntities;
    private Date data;
}
