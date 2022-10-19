package br.com.air_traffic_control.Domain.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "faixaAerovia")
public class FaixaAeroviaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "faixa_id", nullable = false)
    private Long id;

    private int nome;
    private int altitude;
    @OneToMany
    @JoinColumn(name = "horario_id")
    private final List<HorarioEntity> horarioEntities = new ArrayList<>(24);
}