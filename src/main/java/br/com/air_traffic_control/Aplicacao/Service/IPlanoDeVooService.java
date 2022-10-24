package br.com.air_traffic_control.Aplicacao.Service;

import br.com.air_traffic_control.Aplicacao.Dtos.AeroportoDTO;
import br.com.air_traffic_control.Aplicacao.Dtos.FaixaAeroviaDTO;
import br.com.air_traffic_control.Aplicacao.Dtos.PlanoDeVooDTO;
import br.com.air_traffic_control.Aplicacao.Dtos.RotaDTO;

import java.util.List;
public interface IPlanoDeVooService {

    List<RotaDTO> ListarRotasEntreAeroportos(AeroportoDTO origem, AeroportoDTO destino);
    List<FaixaAeroviaDTO> ListarNiveisDeVooLivres(int horaPartida, int velocidadeCruzeiro, AeroportoDTO origem, AeroportoDTO destino);
    String StatusPlanoDeVoo();
    Boolean LiberarPlanoDeVoo(PlanoDeVooDTO planoDeVoo);
    Boolean CancelarPlanoDeVoo(PlanoDeVooDTO planoDeVoo);
    String verificaPlanoDeVoo(PlanoDeVooDTO planoDeVoo);
}
