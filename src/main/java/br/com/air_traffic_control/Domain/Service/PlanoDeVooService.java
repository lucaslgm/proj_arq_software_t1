package br.com.air_traffic_control.Domain.Service;

import br.com.air_traffic_control.Aplicacao.Dtos.AeroportoDTO;
import br.com.air_traffic_control.Aplicacao.Dtos.FaixaAeroviaDTO;
import br.com.air_traffic_control.Aplicacao.Dtos.PlanoDeVooDTO;
import br.com.air_traffic_control.Aplicacao.Dtos.RotaDTO;
import br.com.air_traffic_control.Aplicacao.Service.IPlanoDeVooService;
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
