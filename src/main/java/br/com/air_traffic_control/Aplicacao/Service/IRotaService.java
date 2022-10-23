package br.com.air_traffic_control.Aplicacao.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.air_traffic_control.Aplicacao.Dtos.AeroviaDTO;
import br.com.air_traffic_control.Aplicacao.Dtos.RefGeoDTO;
import br.com.air_traffic_control.Domain.Entities.RotaEntity;

public interface IRotaService {
    RotaEntity CadastrarNovaRota(long origemId, long destinoId, List<Long> aeroviasId);
    List<RotaEntity> findAll();
    List<RotaEntity> consultaRotasEntreDuasRef(String nomeOrigem, String nomeDestino);
}
