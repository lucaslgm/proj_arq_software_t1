package br.com.air_traffic_control.Domain.Service;

import br.com.air_traffic_control.Aplicacao.Dtos.AeroviaDTO;
import br.com.air_traffic_control.Aplicacao.Service.IAeroviaService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AeroviaService implements IAeroviaService {

    public String RelatorioOcupacaoAeroviaporData(Date data, AeroviaDTO aerovia) {
        return null;
    }
}
