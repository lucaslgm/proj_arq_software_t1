package br.com.air_traffic_control;

import br.com.air_traffic_control.Aplicacao.Dtos.AeroviaDTO;
import br.com.air_traffic_control.Aplicacao.Dtos.RefGeoDTO;
import br.com.air_traffic_control.Aplicacao.Service.IAeroviaService;
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

        RefGeoDTO origem = RefGeoDTO
                .builder()
                .nome("GRU")
                .latitude(-23.432200)
                .longitude(-46.469200)
                .build();
        RefGeoDTO destino = RefGeoDTO
                .builder()
                .nome("GRU")
                .latitude(-23.432200)
                .longitude(-46.469200)
                .build();

    }

    private void CreateAerovia(AeroviaDTO aerovia){

        var ret = aeroviaService.CadastrarNovaAerovia(aerovia);

    }
}
