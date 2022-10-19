package br.com.air_traffic_control.Domain.Repositories;

import br.com.air_traffic_control.Domain.Entities.RotaEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRotaRepository extends JpaRepository<RotaEntity, Long> {
    
    @Query("SELECT * FROM Rotas r WHERE r.origem= ?1 AND r.destino= ?2")
    List<RotaEntity> ListarRotasEntreAeroportos(long origem,long destino);
}
