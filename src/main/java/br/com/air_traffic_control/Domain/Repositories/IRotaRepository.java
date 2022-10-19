package br.com.air_traffic_control.Domain.Repositories;

import br.com.air_traffic_control.Domain.Entities.RotaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRotaRepository extends CrudRepository<RotaEntity, Long> {
}
