package br.com.air_traffic_control.Domain.Service;

import br.com.air_traffic_control.Aplicacao.Dtos.AeroportoDTO;
import br.com.air_traffic_control.Aplicacao.Dtos.FaixaAeroviaDTO;
import br.com.air_traffic_control.Aplicacao.Dtos.PlanoDeVooDTO;
import br.com.air_traffic_control.Aplicacao.Dtos.RotaDTO;
import br.com.air_traffic_control.Aplicacao.Service.IPlanoDeVooService;
import br.com.air_traffic_control.Domain.Entities.*;
import br.com.air_traffic_control.Domain.Repositories.*;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlanoDeVooService implements IPlanoDeVooService {
    private final IRotaRepository rotaRepository;
    private final IAeroviaRepository faixaAeroviaRepository;


    @Override
    public List<RotaEntity> ListarRotasEntreAeroportos(AeroportoDTO origem, AeroportoDTO destino) {
        return this.rotaRepository.ListarRotasEntreAeroportos(origem.getId(),destino.getId());
    }

    @Override
    public List<FaixaAeroviaEntity> ListarNiveisDeVooLivres(int horaPartida, int velocidadeCruzeiro, AeroportoDTO origem, AeroportoDTO destino) {
        //return this.faixaAeroviaRepository.ListarniveisDeVooLivres(horaPartida,velocidadeCruzeiro,origem,destino); //quais tabelas pesquisar?
        return null;
    }

    @Override
    public String StatusPlanoDeVoo(PlanoDeVooDTO planoDeVoo) {
        //Lista de selects nas tabelas pesquisando se as informações pesquisadas estão ok
        //RN's
        //Se estiver ok -- insere planoDeVoo.Status = "ok";
        //Se não estiver ok -- return "Conflitos";
        if(true){
            return "Conflito -- (trecho1, trecho2)";
        }
        return "Ok";
    }

    public Boolean AprovarPlanoDeVoo(PlanoDeVooDTO planoDeVoo) {
        //Chama StatusPlanoDeVoo, se "ok" --> insere && update slots --> true
        //Chama StatusPlanoDeVoo, se "Conflito" --> false
        return null;
    }

    public Boolean CancelarPlanoDeVoo(PlanoDeVooDTO planoDeVoo) {
        //PlanoDevoo.status = "Cancelado" -- Update && update slots --> true
        //Se der erro false
        return null;
    }
}
