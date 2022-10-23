package br.com.air_traffic_control.Aplicacao.Service;

import br.com.air_traffic_control.Aplicacao.Dtos.RotaDTO;
import br.com.air_traffic_control.Domain.Entities.RotaEntity;

public interface IRotaService {
    public RotaEntity CadastrarNovaRota(RotaEntity rota);
}
