package com.proj_arq_software_t1.air_traffic_control.Dominio.Repositories;



import com.proj_arq_software_t1.air_traffic_control.Dominio.Entities.AeroviaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAeroviaRepository extends CrudRepository<AeroviaEntity, Long> {
}
