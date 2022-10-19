package com.proj_arq_software_t1.air_traffic_control.Aplicacao.Services;

import com.proj_arq_software_t1.air_traffic_control.Aplicacao.Dtos.AeroviaDTO;
import java.util.Date;

public interface IAeroviaService {
    String RelatorioOcupacaoAeroviaporData(Date data, AeroviaDTO aerovia);
}
