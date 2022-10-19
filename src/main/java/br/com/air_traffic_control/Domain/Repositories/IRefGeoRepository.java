package br.com.air_traffic_control.Domain.Repositories;


import br.com.air_traffic_control.Domain.Entities.AeroviaEntity;
import br.com.air_traffic_control.Domain.Entities.RefGeoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRefGeoRepository extends CrudRepository<RefGeoEntity, Long> {
    List<RefGeoEntity> findAll();
}
