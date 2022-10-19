package com.proj_arq_software_t1.air_traffic_control.Infraestrutura.Repositories;

import com.proj_arq_software_t1.air_traffic_control.Dominio.Entities.PlanoDeVooEntity;
import com.proj_arq_software_t1.air_traffic_control.Dominio.Repositories.IPlanoDeVooRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PlanoDeVooRepository implements IPlanoDeVooRepository {

    @Override
    public <S extends PlanoDeVooEntity> S save(S entity) {
        return null;
    }

    @Override
    public <S extends PlanoDeVooEntity> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<PlanoDeVooEntity> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<PlanoDeVooEntity> findAll() {
        return null;
    }

    @Override
    public Iterable<PlanoDeVooEntity> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(PlanoDeVooEntity entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends PlanoDeVooEntity> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
