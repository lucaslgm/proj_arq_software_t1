package com.proj_arq_software_t1.air_traffic_control.Dominio.Repositories;

import com.proj_arq_software_t1.air_traffic_control.Dominio.Entities.AeroportoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAeroportoRepository extends CrudRepository<AeroportoEntity, Long> {
}
