package br.com.air_traffic_control.Domain.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "rotas")
public class RotaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rota_id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "origem", referencedColumnName="refgeo_id")
    private RefGeoEntity origem;

    @ManyToOne
    @JoinColumn(name = "destino", referencedColumnName="refgeo_id")
    private RefGeoEntity destino;

    @ManyToMany( targetEntity=AeroviaEntity.class )
    private List<AeroviaEntity> conjuntoAeroviaEntities;

    //@Column(name = "data")
    //private Date data;
}
