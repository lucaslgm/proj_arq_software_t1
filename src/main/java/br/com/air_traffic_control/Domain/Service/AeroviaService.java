package br.com.air_traffic_control.Domain.Service;

import br.com.air_traffic_control.Aplicacao.Dtos.AeroviaDTO;
import br.com.air_traffic_control.Aplicacao.Dtos.RefGeoDTO;
import br.com.air_traffic_control.Aplicacao.Service.IAeroviaService;
import br.com.air_traffic_control.Domain.Entities.AeroviaEntity;
import br.com.air_traffic_control.Domain.Entities.RefGeoEntity;
import br.com.air_traffic_control.Domain.Entities.SlotEntity;
import br.com.air_traffic_control.Domain.Repositories.IAeroviaRepository;
import br.com.air_traffic_control.Domain.Repositories.IRefGeoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public long CadastrarNovaRefGeo(RefGeoDTO c) {
        var entity = RefGeoEntity
                .builder()
                .nome(c.getNome())
                .latitude(c.getLatitude())
                .longitude(c.getLongitude())
                .build();

       var ret = refGeoRepository.save(entity);
       return ret.getId();
    };

    @Override
    public List<AeroviaEntity> findAll() {
        List<AeroviaEntity> aerovias = repository.findAll();
        return  aerovias;
    }
    public List<RefGeoEntity> listarReferenciasGeograficas(){
        List<RefGeoEntity> refs = refGeoRepository.findAll();
        return  refs;
    }

    private double CalcularDistancia(RefGeoDTO origem, RefGeoDTO destino){
        double R = 6371;
        double OLAR = origem.getLatitude() * (Math.PI/180);
        double OLOR = origem.getLongitude() * (Math.PI/180);

        double DLAR = destino.getLatitude() * (Math.PI/180);
        double DLOR = destino.getLongitude() * (Math.PI/180);

        double MLAT = (OLAR - DLAR) < 0 ? (OLAR - DLAR) * -1 : (OLAR - DLAR);
        double MLON = (OLOR - DLOR) < 0 ? (OLOR - DLOR) * -1 : (OLOR - DLOR);

        var a = (Math.pow(Math.sin(MLAT/2),2) + Math.cos(OLAR)) * (Math.cos(DLAR) * Math.pow(Math.sin(MLON/2),2));
        var c = 2 * Math.pow(Math.tan(Math.sqrt(a/Math.sqrt(1-a))),-1);
        return R * c;
    }
}
