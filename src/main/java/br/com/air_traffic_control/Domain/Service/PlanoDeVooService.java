package br.com.air_traffic_control.Domain.Service;

import br.com.air_traffic_control.Aplicacao.Dtos.AeroportoDTO;
import br.com.air_traffic_control.Aplicacao.Dtos.AeroviaDTO;
import br.com.air_traffic_control.Aplicacao.Dtos.FaixaAeroviaDTO;
import br.com.air_traffic_control.Aplicacao.Dtos.PlanoDeVooDTO;
import br.com.air_traffic_control.Aplicacao.Dtos.RotaDTO;
import br.com.air_traffic_control.Aplicacao.Service.IPlanoDeVooService;
import br.com.air_traffic_control.Domain.Entities.AeroviaEntity;
import br.com.air_traffic_control.Domain.Entities.SlotEntity;
import br.com.air_traffic_control.Domain.Repositories.IPlanoDeVooRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanoDeVooService implements IPlanoDeVooService {
    private final IPlanoDeVooRepository repository;

    @Autowired
    public PlanoDeVooService(IPlanoDeVooRepository repository) {
        this.repository = repository;
    }
    
    public List<RotaDTO> ListarRotasEntreAeroportos(AeroportoDTO origem, AeroportoDTO destino) {
        return null;
    }

    public List<FaixaAeroviaDTO> ListarNiveisDeVooLivres(int horaPartida, int velocidadeCruzeiro, AeroportoDTO origem, AeroportoDTO destino) {
        return null;
    }

    public String StatusPlanoDeVoo() {
        return null;
    }

    public Boolean LiberarPlanoDeVoo(PlanoDeVooDTO planoDeVoo) {
        return null;
    }

    public Boolean CancelarPlanoDeVoo(PlanoDeVooDTO planoDeVoo) {
        return null;
    }

    @Override
    public String verificaPlanoDeVoo(PlanoDeVooDTO planoDeVoo) {
        int horarioAtual = planoDeVoo.getHorario();

        for(AeroviaEntity aerovia : planoDeVoo.getRota().getConjuntoAerovias()){
            int duracao = (int) Math.ceil(aerovia.getDistancia()/planoDeVoo.getVelocidade());
            for(int i=0; i<duracao; i++){
                if(!aerovia.getSlotByAltiudeAndHorario(planoDeVoo.getAltitude(), horarioAtual).isDisponivel()){
                    return "Aerovia " + aerovia.getNome() +
                     " não disponível para data " + planoDeVoo.getData() +
                     " no horario " + horarioAtual + 
                     " e altitude " + planoDeVoo.getAltitude();
                }
                horarioAtual++;
            }
        }
        return "Ok";
    }

    
}
