package com.proj_arq_software_t1.air_traffic_control.Infraestrutura.Repositories;

import com.proj_arq_software_t1.air_traffic_control.Dominio.Entities.AeroviaEntity;
import com.proj_arq_software_t1.air_traffic_control.Dominio.Repositories.IAeroviaRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class AeroviaRepository implements IAeroviaRepository {

    @Override
    public <S extends AeroviaEntity> S save(S entity) {
        return null;
    }

    @Override
    public <S extends AeroviaEntity> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<AeroviaEntity> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<AeroviaEntity> findAll() {
        return null;
    }

    @Override
    public Iterable<AeroviaEntity> findAllById(Iterable<Long> longs) {
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
    public void delete(AeroviaEntity entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends AeroviaEntity> entities) {

    }

    @Override
    public void deleteAll() {

    }
}