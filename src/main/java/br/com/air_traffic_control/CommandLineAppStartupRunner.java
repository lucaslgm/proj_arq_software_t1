package br.com.air_traffic_control;

import br.com.air_traffic_control.Aplicacao.Dtos.AeroviaDTO;
import br.com.air_traffic_control.Aplicacao.Dtos.RefGeoDTO;
import br.com.air_traffic_control.Aplicacao.Service.IAeroviaService;
import br.com.air_traffic_control.Aplicacao.Service.IRotaService;
import br.com.air_traffic_control.Domain.Entities.AeroviaEntity;
import br.com.air_traffic_control.Domain.Entities.RotaEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.yaml.snakeyaml.util.ArrayUtils;

@Configuration
public class CommandLineAppStartupRunner implements CommandLineRunner {
    private final IAeroviaService aeroviaService;
    private final IRotaService rotaService;

    public CommandLineAppStartupRunner(IAeroviaService aeroviaService, IRotaService rotaService) {
        this.aeroviaService = aeroviaService;
        this.rotaService = rotaService;
    }

    @Override
    public void run(String... args) {
        System.out.println("Startou!");

        RefGeoDTO GRU = RefGeoDTO
                .builder()
                .nome("GRU")
                .latitude(-23.432200)
                .longitude(-46.469200)
                .build();
        RefGeoDTO CGH = RefGeoDTO
                .builder()
                .nome("CGH")
                .latitude(-23.626111)
                .longitude(-46.656389)
                .build();
        RefGeoDTO GIG = RefGeoDTO
                .builder()
                .nome("GIG")
                .latitude(-22.808900)
                .longitude(-43.243600)
                .build();
        RefGeoDTO FLN = RefGeoDTO
                .builder()
                .nome("FLN")
                .latitude(-27.670278)
                .longitude(-48.552500)
                .build();
        RefGeoDTO POA = RefGeoDTO
                .builder()
                .nome("POA")
                .latitude(-29.993889)
                .longitude(-51.171111)
                .build();

        GRU.setId(CreateRefGeo(GRU));
        CGH.setId(CreateRefGeo(CGH));
        GIG.setId(CreateRefGeo(GIG));
        FLN.setId(CreateRefGeo(FLN));
        POA.setId(CreateRefGeo(POA));

        CreateAerovia(GRU,CGH).getSlots().size();
        CreateAerovia(GRU,POA).getSlots().size();
        CreateAerovia(POA,FLN).getSlots().size();
        CreateAerovia(GIG,GRU).getSlots().size();
        CreateAerovia(POA,GIG).getSlots().size();

        CreateRota(POA.getId(), FLN.getId(), converteListaLong(Arrays.asList(3)));
        CreateRota(GRU.getId(), FLN.getId(), converteListaLong(Arrays.asList(2,3)));
        CreateRota(GRU.getId(), GIG.getId(), converteListaLong(Arrays.asList(2,5)));
        CreateRota(GIG.getId(), FLN.getId(), converteListaLong(Arrays.asList(4,2,3)));
        CreateRota(GIG.getId(), CGH.getId(), converteListaLong(Arrays.asList(4,1)));
    }

    private AeroviaEntity CreateAerovia(RefGeoDTO c1, RefGeoDTO c2){
        var ret = aeroviaService.CadastrarNovaAerovia(c1,c2);
        return ret;
    }

    private long CreateRefGeo(RefGeoDTO c){
        var ret = aeroviaService.CadastrarNovaRefGeo(c);
        return ret;
    }

    private RotaEntity CreateRota(long origemId, long destinoId, List<Long> aeroviasId){
        var ret = rotaService.CadastrarNovaRota(origemId, destinoId, aeroviasId);
        return ret;
    }

    private List<Long> converteListaLong(List<Integer> list){
        List<Long> ar = new ArrayList<>();
        for(int i : list) ar.add(Long.valueOf(i));
        return ar;
    }
}
