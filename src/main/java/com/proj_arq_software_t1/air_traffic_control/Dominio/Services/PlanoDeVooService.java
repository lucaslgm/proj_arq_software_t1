package com.proj_arq_software_t1.air_traffic_control.Dominio.Services;

import com.proj_arq_software_t1.air_traffic_control.Aplicacao.Dtos.*;
import com.proj_arq_software_t1.air_traffic_control.Aplicacao.Services.IPlanoDeVooService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanoDeVooService implements IPlanoDeVooService {

    public List<RotaDTO> ListarRotasEntreAeroportos(AeroportoDTO origem, AeroportoDTO destino) {
        return null;
    }

    public List<FaixaAeroviaDTO> ListarNiveisDeVooLivres(int horaPartida, int velocidadeCruzeiro, AeroportoDTO origem, AeroportoDTO destino) {
        return null;
    }

    public String StatusPlanoDeVoo() {
        return null;
    }

    public Boolean AprovarPlanoDeVoo(PlanoDeVooDTO planoDeVoo) {
        return null;
    }

    public Boolean CancelarPlanoDeVoo(PlanoDeVooDTO planoDeVoo) {
        return null;
    }
}
