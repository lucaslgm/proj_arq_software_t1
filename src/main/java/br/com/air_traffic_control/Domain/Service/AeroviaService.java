package br.com.air_traffic_control.Domain.Service;

import br.com.air_traffic_control.Aplicacao.Dtos.AeroviaDTO;
import br.com.air_traffic_control.Aplicacao.Service.IAeroviaService;
import br.com.air_traffic_control.Domain.Entities.AeroviaEntity;
import br.com.air_traffic_control.Domain.Entities.RefGeoEntity;
import br.com.air_traffic_control.Domain.Entities.SlotEntity;
import br.com.air_traffic_control.Domain.Repositories.IAeroviaRepository;
import br.com.air_traffic_control.Domain.Repositories.IRefGeoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AeroviaService implements IAeroviaService {
    private final IAeroviaRepository repository;
    private final IRefGeoRepository refGeoRepository;

    @Autowired
    public AeroviaService(IAeroviaRepository repository, IRefGeoRepository refGeoRepository) {
        this.repository = repository;
        this.refGeoRepository = refGeoRepository;
    }

    public String RelatorioOcupacaoAeroviaporData(Date data, AeroviaDTO aerovia) {
        return null;
    }

    @Override
    public AeroviaEntity CadastrarNovaAerovia(RefGeoEntity origem, RefGeoEntity destino, double distancia) {
        List<SlotEntity> slots = new ArrayList<>();
        int altitude = 2500;

        for(int i = 1; i < 11; i++){
            for(int j = 0; j < 24; j++){
                SlotEntity slot = SlotEntity.builder()
                        .altitude(altitude)
                        .disponivel(true)
                        .hora(j)
                        .build();
                slots.add(slot);
            }
            altitude+=1000;
        }


        AeroviaEntity aerovia = AeroviaEntity
                .builder()
                .origem(origem)
                .destino(destino)
                .distancia(distancia)
                .data(new Date())
                .nome(origem.getNome()+"-"+ destino.getNome())
                .build();
        aerovia.getSlots().addAll(slots);
        var ret = repository.save(aerovia);

        return ret;
    }

    @Override
    public List<AeroviaEntity> findAll() {
        List<AeroviaEntity> aerovias = repository.findAll();
        return  aerovias;
    }
    public List<RefGeoEntity> listarReferenciasGeograficas(){
        List<RefGeoEntity> refs = refGeoRepository.findAll();
        return  refs;
    }
}
