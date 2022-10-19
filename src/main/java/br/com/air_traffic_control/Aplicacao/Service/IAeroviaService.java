package br.com.air_traffic_control.Aplicacao.Service;


import br.com.air_traffic_control.Aplicacao.Dtos.AeroviaDTO;

import java.util.Date;

public interface IAeroviaService {
    String RelatorioOcupacaoAeroviaporData(Date data, AeroviaDTO aerovia);
}
