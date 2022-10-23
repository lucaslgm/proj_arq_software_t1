package br.com.air_traffic_control.Api.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import br.com.air_traffic_control.Aplicacao.Service.IRotaService;
import br.com.air_traffic_control.Domain.Entities.RotaEntity;

@RestController
@RequestMapping("/rotas")
public class RotaController {
    private final IRotaService service;

    @Autowired
    public RotaController(IRotaService service) {
        this.service = service;
    }

    // @PostMapping("/save")
    // public RotaEntity save(@RequestBody Long origemId, Long destinoId, List<Long> aeroviasIds){
    //    return this.service.CadastrarNovaRota(origemId, destinoId, aeroviasIds);
    // }

    @GetMapping
    public List<RotaEntity> findAll() {
        return this.service.findAll();
    }

    @GetMapping("/consultaEntre")
    @ResponseBody
    public List<RotaEntity> consultaRotasEntreDuasRef(@RequestParam String origem, @RequestParam String destino) {
        return this.service.consultaRotasEntreDuasRef(origem, destino);
    }
}
