package br.com.air_traffic_control.Domain.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.air_traffic_control.Aplicacao.Dtos.AeroviaDTO;
import br.com.air_traffic_control.Aplicacao.Dtos.RefGeoDTO;
import br.com.air_traffic_control.Aplicacao.Service.IRotaService;
import br.com.air_traffic_control.Domain.Entities.AeronaveEntity;
import br.com.air_traffic_control.Domain.Entities.AeroviaEntity;
import br.com.air_traffic_control.Domain.Entities.RefGeoEntity;
import br.com.air_traffic_control.Domain.Entities.RotaEntity;
import br.com.air_traffic_control.Domain.Repositories.IAeroviaRepository;
import br.com.air_traffic_control.Domain.Repositories.IRefGeoRepository;
import br.com.air_traffic_control.Domain.Repositories.IRotaRepository;

@Service
public class RotaService implements IRotaService{
    private final IRotaRepository repository;
    private final IRefGeoRepository refGeoRepository;
    private final IAeroviaRepository aeroviaRepository;

    @Autowired
    public RotaService(IRotaRepository repository, IRefGeoRepository refGeoRepository, IAeroviaRepository aeroviaRepository){
        this.repository = repository;
        this.refGeoRepository = refGeoRepository;
        this.aeroviaRepository = aeroviaRepository;
    }

    @Override
    public RotaEntity CadastrarNovaRota(long origemId, long destinoId, List<Long> aeroviasId) {
        if(refGeoRepository.existsById(origemId) && refGeoRepository.existsById(destinoId)){

            List<AeroviaEntity> aerovias = new ArrayList<>();
            for(Long id : aeroviasId) {
                if(aeroviaRepository.existsById(id)) aerovias.add(aeroviaRepository.findById(id).get());
                else {
                    System.out.println("Aerovia "+id+" não encontrada.");
                    return null;
                }
            }
            
            RotaEntity entity = RotaEntity
            .builder()
            .origem(refGeoRepository.findById(origemId).get())
            .destino(refGeoRepository.findById(destinoId).get())
            .conjuntoAeroviaEntities(aerovias)
            .build();
            
            return repository.save(entity);
        }

        System.out.println("ID de origem ou destino inválido.");
        return null;
    }

    @Override
    public List<RotaEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public List<RotaEntity> consultaRotasEntreDuasRef(String nomeOrigem, String nomeDestino) {
        List<RotaEntity> rotas = new ArrayList<>();
        for(RotaEntity r : repository.findAll()){
            if(r.getOrigem().getNome().equalsIgnoreCase(nomeOrigem) &&
                r.getDestino().getNome().equalsIgnoreCase(nomeDestino))
                rotas.add(r);
        }
        return rotas;
    }
    
}
