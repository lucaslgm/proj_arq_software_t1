package br.com.air_traffic_control.Api.Controllers;

import br.com.air_traffic_control.Aplicacao.Service.IAeroviaService;
import br.com.air_traffic_control.Domain.Entities.AeroviaEntity;
import br.com.air_traffic_control.Domain.Entities.RefGeoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/aerovia")
public class AeroviaController {
    private final IAeroviaService service;

    @Autowired
    public AeroviaController(IAeroviaService service) {
        this.service = service;
    }

//    @PostMapping("/save")
//    public AeroviaEntity save(@RequestBody RefGeoEntity origem, RefGeoEntity destino, double distancia){
//        return this.service.CadastrarNovaAerovia(origem,destino,distancia);
//    }

    @GetMapping
    public List<AeroviaEntity> findAll() {
        return this.service.findAll();
    }

    @GetMapping("/refs")
    public List<RefGeoEntity> listarReferenciasGeograficas(){
        List<RefGeoEntity> refs = service.listarReferenciasGeograficas();
        return  refs;
    }
}


