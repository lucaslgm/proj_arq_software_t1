package br.com.air_traffic_control.Api.Controllers;

import br.com.air_traffic_control.Aplicacao.Dtos.*;
import br.com.air_traffic_control.Domain.Entities.FaixaAeroviaEntity;
import br.com.air_traffic_control.Domain.Entities.RotaEntity;
import br.com.air_traffic_control.Aplicacao.Service.*;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/controleTrafego")
public class TrafegoAereoController {
    private final IPlanoDeVooService planoDeVooService;

    @GetMapping
    List<RotaEntity> ListarRotasEntreAeroportos(AeroportoDTO origem, AeroportoDTO destino){
        return this.planoDeVooService.ListarRotasEntreAeroportos(origem, destino);
    };
    List<FaixaAeroviaEntity> ListarNiveisDeVooLivres(int horaPartida, int velocidadeCruzeiro, AeroportoDTO origem, AeroportoDTO destino){
        return this.planoDeVooService.ListarNiveisDeVooLivres(horaPartida, velocidadeCruzeiro, origem, destino);
    };
    String StatusPlanoDeVoo(PlanoDeVooDTO planoDeVoo){
        //TODO
        return this.planoDeVooService.StatusPlanoDeVoo(planoDeVoo);
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
