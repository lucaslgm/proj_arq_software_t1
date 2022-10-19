package br.com.air_traffic_control.Domain.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "aerovias")
public class AeroviaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aerovia_id", nullable = false)
    private Long id;

    @ElementCollection(targetClass = SlotEntity.class, fetch = FetchType.EAGER)
    private final List<SlotEntity> slots = new ArrayList<>(10);

    @ManyToOne
    @JoinColumn(name = "origem", referencedColumnName="refgeo_id")
    private RefGeoEntity origem;

    @ManyToOne
    @JoinColumn(name = "destino", referencedColumnName="refgeo_id")
    private RefGeoEntity destino;

    private String nome;
    private double distancia;
    private Date data;
}