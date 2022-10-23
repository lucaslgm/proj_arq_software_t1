package br.com.air_traffic_control.Api.Controllers;

import br.com.air_traffic_control.Aplicacao.Dtos.*;
import br.com.air_traffic_control.Aplicacao.Service.IAeroviaService;
import br.com.air_traffic_control.Aplicacao.Service.IRotaService;
import br.com.air_traffic_control.Domain.Entities.RotaEntity;
import br.com.air_traffic_control.Domain.Entities.SlotEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class TrafegoAereoController {
    private final IRotaService rotaService;
    private final IAeroviaService aeroviaService;

    @Autowired
    public TrafegoAereoController(IRotaService rotaService, IAeroviaService aeroviaService) {
        this.rotaService = rotaService;
        this.aeroviaService = aeroviaService;
    }

    @GetMapping("/rotas/listarRotasEntreAeroportos")
    List<RotaEntity> ListarRotasEntreAeroportos(@RequestParam("origem") String origem, @RequestParam("destino") String destino){
        return  rotaService.ConsultarRotasEntreDoisAeroportos(origem, destino);
    }

    @GetMapping("/rotas/listarSlotsLivres")
    List<SlotEntity> ListarSlotsLivres(@RequestParam("partida") int horaPartida,
                                       @RequestParam("velocidade") int velocidadeCruzeiro,
                                       @RequestParam("aerovia") long aerovia){

        return aeroviaService.ListarSlotsLivres(aerovia,horaPartida,velocidadeCruzeiro);
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
