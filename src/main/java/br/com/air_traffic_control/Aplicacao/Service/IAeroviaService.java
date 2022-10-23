package br.com.air_traffic_control.Aplicacao.Service;


import br.com.air_traffic_control.Aplicacao.Dtos.AeroviaDTO;
import br.com.air_traffic_control.Aplicacao.Dtos.RefGeoDTO;
import br.com.air_traffic_control.Domain.Entities.AeroviaEntity;
import br.com.air_traffic_control.Domain.Entities.RefGeoEntity;

import java.util.Date;
import java.util.List;

public interface IAeroviaService {
    String RelatorioOcupacaoAeroviaporData(Date data, AeroviaDTO aerovia);

//    AeroviaEntity CadastrarNovaAerovia(RefGeoEntity origem, RefGeoEntity destino, double distancia);

    AeroviaEntity CadastrarNovaAerovia(RefGeoDTO c1, RefGeoDTO c2);

    long CadastrarNovaRefGeo(RefGeoDTO c1);

    List<AeroviaEntity> findAll();
    public List<RefGeoEntity> listarReferenciasGeograficas();
}
