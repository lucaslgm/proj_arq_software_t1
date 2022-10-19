package br.com.air_traffic_control.Aplicacao.Service;

import br.com.air_traffic_control.Aplicacao.Dtos.AeroportoDTO;
import br.com.air_traffic_control.Aplicacao.Dtos.FaixaAeroviaDTO;
import br.com.air_traffic_control.Aplicacao.Dtos.PlanoDeVooDTO;
import br.com.air_traffic_control.Aplicacao.Dtos.RotaDTO;
import br.com.air_traffic_control.Domain.Entities.FaixaAeroviaEntity;
import br.com.air_traffic_control.Domain.Entities.RotaEntity;

import java.util.List;
public interface IPlanoDeVooService {

    List<RotaEntity> ListarRotasEntreAeroportos(AeroportoDTO origem, AeroportoDTO destino);
    List<FaixaAeroviaEntity> ListarNiveisDeVooLivres(int horaPartida, int velocidadeCruzeiro, AeroportoDTO origem, AeroportoDTO destino);
    String StatusPlanoDeVoo(PlanoDeVooDTO planoDeVoo);
    Boolean AprovarPlanoDeVoo(PlanoDeVooDTO planoDeVoo);
    Boolean CancelarPlanoDeVoo(PlanoDeVooDTO planoDeVoo);

}
