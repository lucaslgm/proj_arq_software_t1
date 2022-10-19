package br.com.air_traffic_control.Infraestrutura.Repositories;

import br.com.air_traffic_control.Domain.Entities.RefGeoEntity;
import br.com.air_traffic_control.Domain.Repositories.IRefGeoRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RefGeoRepository implements IRefGeoRepository {

    @Override
    public <S extends RefGeoEntity> S save(S entity) {
        return null;
    }

    @Override
    public <S extends RefGeoEntity> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<RefGeoEntity> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<RefGeoEntity> findAll() {
        return null;
    }

    @Override
    public Iterable<RefGeoEntity> findAllById(Iterable<Long> longs) {
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
    public void delete(RefGeoEntity entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends RefGeoEntity> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
