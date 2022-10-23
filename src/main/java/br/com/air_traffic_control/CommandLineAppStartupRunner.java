package br.com.air_traffic_control;

import br.com.air_traffic_control.Aplicacao.Dtos.AeronaveDTO;
import br.com.air_traffic_control.Aplicacao.Dtos.RefGeoDTO;
import br.com.air_traffic_control.Aplicacao.Service.*;
import br.com.air_traffic_control.Domain.Entities.AeronaveEntity;
import br.com.air_traffic_control.Domain.Entities.AeroportoEntity;
import br.com.air_traffic_control.Domain.Entities.RotaEntity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Date;

@Configuration
public class CommandLineAppStartupRunner implements CommandLineRunner {
    private final IAeroviaService aeroviaService;
    private final IAeronaveService aeronaveService;
    private final IRotaService rotaService;
    private final IAeroportoService aeroportoService;
    private final IRefGeoService refGeoService;

    public CommandLineAppStartupRunner(IAeroviaService aeroviaService, IAeronaveService aeronaveService, IRotaService rotaService, IAeroportoService aeroportoService, IRefGeoService refGeoService) {
        this.aeroviaService = aeroviaService;
        this.aeronaveService = aeronaveService;
        this.rotaService = rotaService;
        this.aeroportoService = aeroportoService;
        this.refGeoService = refGeoService;
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

        CreateAerovia(GRU,CGH);
        CreateAerovia(GRU,POA);
        CreateAerovia(POA,FLN);
        CreateAerovia(GIG,GRU);
        CreateAerovia(POA,GIG);

        var A320 = AeronaveDTO
                .builder()
                .autonomia(6100)
                .Prefixo("PR-GUO")
                .VelocidadeCruzeiro(875)
                .build();
        CreateAeronave(A320);

        var B737 = AeronaveDTO
                .builder()
                .autonomia(5765)
                .Prefixo("PR-TAM")
                .VelocidadeCruzeiro(850)
                .build();
        CreateAeronave(B737);

        var POA_GRU = RotaEntity
                .builder()
                .data(new Date())
                .origem("POA")
                .destino("GRU")
                .build();

        var A1 = aeroviaService.ObterAerovia(5);
        var A2 = aeroviaService.ObterAerovia(4);

        POA_GRU.setConjuntoAerovias(new ArrayList<>());
        POA_GRU.getConjuntoAerovias().add(A1.get());
        POA_GRU.getConjuntoAerovias().add(A2.get());
        CreateRota(POA_GRU);

        var POA_FLN = RotaEntity
                .builder()
                .data(new Date())
                .origem("POA")
                .destino("FLN")
                .build();

        var A3 = aeroviaService.ObterAerovia(3);

        POA_FLN.setConjuntoAerovias(new ArrayList<>());
        POA_FLN.getConjuntoAerovias().add(A3.get());
        CreateRota(POA_FLN);

        var RGRU = refGeoService.ObterRefGeo(1);
        var RCGH = refGeoService.ObterRefGeo(2);
        var RGIG = refGeoService.ObterRefGeo(3);
        var RFLN = refGeoService.ObterRefGeo(4);
        var RPOA = refGeoService.ObterRefGeo(5);

        var AGRU = AeroportoEntity
                .builder()
                .nome("AI Governador André Franco Montoro")
                .iata("GRU")
                .localizacao(RGRU.get())
                .build();
        var ACGH = AeroportoEntity
                .builder()
                .nome("AI Deputado Freitas Nobre")
                .iata("CGH")
                .localizacao(RCGH.get())
                .build();
        var AGIG = AeroportoEntity
                .builder()
                .nome("AI Tom Jobim")
                .iata("GIG")
                .localizacao(RGIG.get())
                .build();
        var AFLN = AeroportoEntity
                .builder()
                .nome("AI Hercílio Luz")
                .iata("FLN")
                .localizacao(RFLN.get())
                .build();
        var APOA = AeroportoEntity
                .builder()
                .nome("AI Salgado Filho")
                .iata("POA")
                .localizacao(RPOA.get())
                .build();

        CreateAeroporto(AGRU);
        CreateAeroporto(ACGH);
        CreateAeroporto(AGIG);
        CreateAeroporto(AFLN);
        CreateAeroporto(APOA);
    }

    private void CreateAerovia(RefGeoDTO c1, RefGeoDTO c2){
        aeroviaService.CadastrarNovaAerovia(c1,c2);
    }

    private long CreateRefGeo(RefGeoDTO c){
        return refGeoService.CadastrarNovaRefGeo(c);
    }

    private AeronaveEntity CreateAeronave(AeronaveDTO aeronave){
        return aeronaveService.CadastrarAeronave(aeronave);
    }

    private void CreateRota(RotaEntity rota){
        rotaService.CadastrarNovaRota(rota);
    }

    private void CreateAeroporto(AeroportoEntity aeroporto){
        aeroportoService.CadastrarNovoAeroporto(aeroporto);
    }
}
