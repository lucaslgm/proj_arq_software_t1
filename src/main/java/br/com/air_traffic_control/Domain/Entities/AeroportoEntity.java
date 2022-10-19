package br.com.air_traffic_control.Domain.Entities;

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
@Table(name = "aeroportos")
public class AeroportoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aeroporto_id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "localizacao", referencedColumnName = "refgeo_id")
    private RefGeoEntity localizacao;

    private String nome;
    private String iata;
}
