package br.com.air_traffic_control.Domain.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "aerovias")
public class AeroviaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aerovia_id", nullable = false)
    private Long id;

    @OneToMany( targetEntity=FaixaAeroviaEntity.class )
    private List<FaixaAeroviaEntity> faixas;

    @ManyToOne
    @JoinColumn(name = "origem", referencedColumnName="refgeo_id")
    private RefGeoEntity origem;

    @ManyToOne
    @JoinColumn(name = "destino", referencedColumnName="refgeo_id")
    private RefGeoEntity destino;

    private String nome;
    private int distancia;
}