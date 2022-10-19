package br.com.air_traffic_control.Domain.Repositories;


import br.com.air_traffic_control.Domain.Entities.PlanoDeVooEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlanoDeVooRepository extends CrudRepository<PlanoDeVooEntity, Long> {
}
