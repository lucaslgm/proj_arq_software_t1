package br.com.air_traffic_control.Aplicacao.Service;

import br.com.air_traffic_control.Aplicacao.Dtos.RefGeoDTO;
import br.com.air_traffic_control.Domain.Entities.AeroviaEntity;
import java.util.List;
import java.util.Optional;

public interface IAeroviaService {
    AeroviaEntity CadastrarNovaAerovia(RefGeoDTO c1, RefGeoDTO c2);
    Optional<AeroviaEntity> ObterAerovia(long id);
    List<AeroviaEntity> findAll();
}
