package com.proj_arq_software_t1.air_traffic_control.Dominio.Services;

import com.proj_arq_software_t1.air_traffic_control.Aplicacao.Dtos.AeroviaDTO;
import com.proj_arq_software_t1.air_traffic_control.Aplicacao.Services.IAeroviaService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AeroviaService implements IAeroviaService {

    public String RelatorioOcupacaoAeroviaporData(Date data, AeroviaDTO aerovia) {
        return null;
    }
}
