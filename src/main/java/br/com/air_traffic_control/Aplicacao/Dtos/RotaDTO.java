package br.com.air_traffic_control.Aplicacao.Dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RotaDTO {
    private RefGeoDTO origem;
    private RefGeoDTO destino;
    private ArrayList<AeroviaDTO> conjuntoAerovias;
}
