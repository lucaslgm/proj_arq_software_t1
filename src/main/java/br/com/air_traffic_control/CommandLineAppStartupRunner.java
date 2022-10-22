package br.com.air_traffic_control;

import br.com.air_traffic_control.Aplicacao.Dtos.AeroviaDTO;
import br.com.air_traffic_control.Aplicacao.Dtos.RefGeoDTO;
import br.com.air_traffic_control.Aplicacao.Service.IAeroviaService;
import br.com.air_traffic_control.Domain.Entities.AeroviaEntity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommandLineAppStartupRunner implements CommandLineRunner {
    private final IAeroviaService aeroviaService;

    public CommandLineAppStartupRunner(IAeroviaService aeroviaService) {
        this.aeroviaService = aeroviaService;
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
    }

    private AeroviaEntity CreateAerovia(RefGeoDTO c1, RefGeoDTO c2){
        var ret = aeroviaService.CadastrarNovaAerovia(c1,c2);
        return ret;
    }

    private long CreateRefGeo(RefGeoDTO c){
        var ret = aeroviaService.CadastrarNovaRefGeo(c);
        return ret;
    }
}
