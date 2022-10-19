package com.proj_arq_software_t1.air_traffic_control.Aplicacao.Services;

import com.proj_arq_software_t1.air_traffic_control.Aplicacao.Dtos.*;
import java.util.List;
public interface IPlanoDeVooService {

    List<RotaDTO> ListarRotasEntreAeroportos(AeroportoDTO origem, AeroportoDTO destino);
    List<FaixaAeroviaDTO> ListarNiveisDeVooLivres(int horaPartida, int velocidadeCruzeiro, AeroportoDTO origem, AeroportoDTO destino);
    String StatusPlanoDeVoo();
    Boolean AprovarPlanoDeVoo(PlanoDeVooDTO planoDeVoo);
    Boolean CancelarPlanoDeVoo(PlanoDeVooDTO planoDeVoo);

}
