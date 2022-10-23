package br.com.air_traffic_control.Domain.Service;

import br.com.air_traffic_control.Aplicacao.Service.IRotaService;
import br.com.air_traffic_control.Domain.Entities.RotaEntity;
import br.com.air_traffic_control.Domain.Repositories.IRotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RotaService implements IRotaService {
    private final IRotaRepository repository;

    @Autowired
    public RotaService(IRotaRepository repository) {
        this.repository = repository;
    }

    @Override
    public RotaEntity CadastrarNovaRota(RotaEntity rota) {
        return repository.save(rota);
    }

    @Override
    public List<RotaEntity> ConsultarRotasEntreDoisAeroportos(String origem, String destino) {
        return repository.findAllByOrigemAndDestino(origem, destino);
    }

    @Override
    public List<RotaEntity> ListarRotas() {
        return repository.findAll();
    }
}
