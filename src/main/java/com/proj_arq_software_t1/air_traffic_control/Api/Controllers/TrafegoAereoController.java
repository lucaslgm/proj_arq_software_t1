package com.proj_arq_software_t1.air_traffic_control.Api.Controllers;

import com.proj_arq_software_t1.air_traffic_control.Aplicacao.Dtos.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/controleTrafego")
public class TrafegoAereoController {

    List<RotaDTO> ListarRotasEntreAeroportos(AeroportoDTO origem, AeroportoDTO destino){
        //TODO
        return  new ArrayList<>();
    };
    List<FaixaAeroviaDTO> ListarNiveisDeVooLivres(int horaPartida, int velocidadeCruzeiro, AeroportoDTO origem, AeroportoDTO destino){
        //TODO
        return  new ArrayList<>();
    };
    String StatusPlanoDeVoo(){
        //TODO
        return "";
    };
    Boolean AprovarPlanoDeVoo(PlanoDeVooDTO planoDeVoo){
        //TODO
        return false;
    };
    Boolean CancelarPlanoDeVoo(PlanoDeVooDTO planoDeVoo){
        //TODO
        return false;
    };

    String RelatorioOcupacaoAeroviaporData(Date data, AeroviaDTO aerovia){
        //TODO
        return "";
    };
    
}
