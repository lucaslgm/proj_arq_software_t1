package br.com.air_traffic_control.Aplicacao.Dtos;

import br.com.air_traffic_control.Domain.Entities.RefGeoEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AeroportoDTO {
    private RefGeoEntity localizacao;
    private String nome;
    private String iata;
}
