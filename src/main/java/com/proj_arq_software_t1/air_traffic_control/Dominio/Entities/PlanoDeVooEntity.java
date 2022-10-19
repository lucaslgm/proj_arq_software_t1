package com.proj_arq_software_t1.air_traffic_control.Dominio.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "planoDeVoo")
public class PlanoDeVooEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "planoDeVoo_id", nullable = false)
    private Long id;
    @OneToOne
    @JoinColumn(name = "rota_id")
    private RotaEntity rotaEntity;
    private int altitude;
    private int velocidade;
    private Date data;
    private int horario;
    private String status;
    private int numeroVoo;
}
