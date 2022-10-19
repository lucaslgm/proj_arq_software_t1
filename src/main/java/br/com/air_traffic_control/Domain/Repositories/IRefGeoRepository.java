package br.com.air_traffic_control.Domain.Repositories;


import br.com.air_traffic_control.Domain.Entities.RefGeoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRefGeoRepository extends CrudRepository<RefGeoEntity, Long> {
}
