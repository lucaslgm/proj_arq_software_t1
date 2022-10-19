package br.com.air_traffic_control.Domain.Entities;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rota_id", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "aeroporto_origem", referencedColumnName="aeroporto_id")
    private AeroportoEntity origem;
    @ManyToOne
    @JoinColumn(name = "aeroporto_destino", referencedColumnName="aeroporto_id")
    private AeroportoEntity destino;
    @OneToMany
    private List<AeroviaEntity> conjuntoAeroviaEntities;
    private Date data;
}
