package br.com.air_traffic_control.Domain.Service;

import br.com.air_traffic_control.Aplicacao.Dtos.AeroviaDTO;
import br.com.air_traffic_control.Aplicacao.Dtos.RefGeoDTO;
import br.com.air_traffic_control.Aplicacao.Service.IAeroviaService;
import br.com.air_traffic_control.Domain.Entities.AeroviaEntity;
import br.com.air_traffic_control.Domain.Entities.RefGeoEntity;
import br.com.air_traffic_control.Domain.Entities.SlotEntity;
import br.com.air_traffic_control.Domain.Repositories.IAeroviaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AeroviaService implements IAeroviaService {
    private final IAeroviaRepository repository;

    @Autowired
    public AeroviaService(IAeroviaRepository repository) {
        this.repository = repository;
    }

    public String RelatorioOcupacaoAeroviaporData(Date data, AeroviaDTO aerovia) {
        return null;
    }

    @Override
    public AeroviaEntity CadastrarNovaAerovia(RefGeoDTO c1, RefGeoDTO c2) {

        var distancia = CalcularDistancia(c1,c2);

        RefGeoEntity origem = RefGeoEntity
                .builder()
                .id(c1.getId())
                .nome(c1.getNome())
                .latitude(c1.getLatitude())
                .longitude(c1.getLongitude())
                .build();

        RefGeoEntity destino = RefGeoEntity
                .builder()
                .id(c2.getId())
                .nome(c2.getNome())
                .latitude(c2.getLatitude())
                .longitude(c2.getLongitude())
                .build();

        AeroviaEntity entity = AeroviaEntity
                .builder()
                .origem(origem)
                .destino(destino)
                .distancia(distancia)
                .nome(origem.getNome()+"-"+ destino.getNome())
                .build();

        for(int i = 25000; i < 35000; i+=1000){
            for(int j = 0; j < 24; j++){
                int altitude = i;
                int hora = j;
                entity.getSlots().add(new SlotEntity(i,j,true));
            }
        }

        return repository.save(entity);
    }

    @Override
    public Optional<AeroviaEntity> ObterAerovia(long id) {
        return repository.findById(id);
    }

    @Override
    public List<AeroviaEntity> findAll() {
        List<AeroviaEntity> aerovias = repository.findAll();
        return  aerovias;
    }

    @Override
    public List<SlotEntity> ListarSlotsLivres(long aerovia, int partida, double velocidade) {
        var aux  = repository.findById(aerovia).get();
        var slots = aux.getSlots();
        List<SlotEntity> list = new ArrayList<>();
        List<Integer> indexes = new ArrayList<>();

        var qtd = Math.ceil(aux.getDistancia()/ velocidade);

        if(qtd == 1){
            slots.forEach(s -> {
                if(s.getHora() == partida && s.isDisponivel()) {
                    list.add(s);
                }
            });
            return list;
        }

        slots.forEach(s -> {
            if(s.getHora() == partida && s.isDisponivel()) {
                indexes.add(slots.indexOf(s));
            }
        });

        indexes.forEach(i -> {
            for(int j = i; j < i+qtd; j++){
                list.add(slots.get(j));
            }
        });

        return list;
    }

    private double CalcularDistancia(RefGeoDTO origem, RefGeoDTO destino){
        double R = 6371;
        double dLat = Math.toRadians(destino.getLatitude() - origem.getLatitude());
        double dLng = Math.toRadians(destino.getLongitude() - origem.getLongitude());
        double sindLat = Math.sin(dLat / 2);
        double sindLng = Math.sin(dLng / 2);
        double a = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)
                * Math.cos(Math.toRadians(origem.getLatitude()))
                * Math.cos(Math.toRadians(destino.getLatitude()));
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return Math.ceil(R * c);
    }
}
