package com.proj_arq_software_t1.air_traffic_control.Infraestrutura.Repositories;

import com.proj_arq_software_t1.air_traffic_control.Dominio.Entities.AeroportoEntity;
import com.proj_arq_software_t1.air_traffic_control.Dominio.Repositories.IAeroportoRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class AeroportoRepository implements IAeroportoRepository {

    @Override
    public <S extends AeroportoEntity> S save(S entity) {
        return null;
    }

    @Override
    public <S extends AeroportoEntity> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<AeroportoEntity> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<AeroportoEntity> findAll() {
        return null;
    }

    @Override
    public Iterable<AeroportoEntity> findAllById(Iterable<Long> longs) {
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
    public void delete(AeroportoEntity entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends AeroportoEntity> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
