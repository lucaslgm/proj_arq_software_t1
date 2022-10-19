package br.com.air_traffic_control.Domain.Entities;

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
@Table(name = "aerovia")
public class AeroviaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aerovia_id", nullable = false)
    private Long id;

    @OneToMany
    @JoinColumn(name = "faixa_id")
    private final List<FaixaAeroviaEntity> faixas = new ArrayList<>(10);

    @ManyToOne
    @JoinColumn(name = "refgeo_id_origem", referencedColumnName="refgeo_id")
    private RefGeoEntity origem;

    @ManyToOne
    @JoinColumn(name = "refgeo_id_destino", referencedColumnName="refgeo_id")
    private RefGeoEntity destino;

    private String nome;
    private int distancia;
    private LocalDate data;
}