package com.proj_arq_software_t1.air_traffic_control.Aplicacao.Dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PlanoDeVooDTO {
    private int id;
    private RotaDTO rota;
    private int altitude;
    private int velocidade;
    private Date data;
    private int horario;
    private String status;
    private int numeroVoo;
}

