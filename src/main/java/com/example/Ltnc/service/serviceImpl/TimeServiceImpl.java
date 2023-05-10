package com.example.Ltnc.service.serviceImpl;

import com.example.Ltnc.model.domain.Time;
import com.example.Ltnc.model.repository.TimeRepository;
import com.example.Ltnc.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class TimeServiceImpl implements TimeService {

    @Autowired
    private TimeRepository timeRepo;

    @Override
    public void flush() {
        timeRepo.flush();
    }

    @Override
    public <S extends Time> S saveAndFlush(S entity) {
        return timeRepo.saveAndFlush(entity);
    }

    @Override
    public <S extends Time> List<S> saveAllAndFlush(Iterable<S> entities) {
        return timeRepo.saveAllAndFlush(entities);
    }

    @Override
    @Deprecated
    public void deleteInBatch(Iterable<Time> entities) {
        timeRepo.deleteInBatch(entities);
    }

    @Override
    public void deleteAllInBatch(Iterable<Time> entities) {
        timeRepo.deleteAllInBatch(entities);
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {
        timeRepo.deleteAllByIdInBatch(longs);
    }

    @Override
    public void deleteAllInBatch() {
        timeRepo.deleteAllInBatch();
    }

    @Override
    @Deprecated
    public Time getOne(Long aLong) {
        return timeRepo.getOne(aLong);
    }

    @Override
    @Deprecated
    public Time getById(Long aLong) {
        return timeRepo.getById(aLong);
    }

    @Override
    public Time getReferenceById(Long aLong) {
        return timeRepo.getReferenceById(aLong);
    }

    @Override
    public <S extends Time> List<S> findAll(Example<S> example) {
        return timeRepo.findAll(example);
    }

    @Override
    public <S extends Time> List<S> findAll(Example<S> example, Sort sort) {
        return timeRepo.findAll(example, sort);
    }

    @Override
    public <S extends Time> List<S> saveAll(Iterable<S> entities) {
        return timeRepo.saveAll(entities);
    }

    @Override
    public List<Time> findAll() {
        return timeRepo.findAll();
    }

    @Override
    public List<Time> findAllById(Iterable<Long> longs) {
        return timeRepo.findAllById(longs);
    }

    @Override
    public <S extends Time> S save(S entity) {
        return timeRepo.save(entity);
    }

    @Override
    public Optional<Time> findById(Long aLong) {
        return timeRepo.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return timeRepo.existsById(aLong);
    }

    @Override
    public long count() {
        return timeRepo.count();
    }

    @Override
    public void deleteById(Long aLong) {
        timeRepo.deleteById(aLong);
    }

    @Override
    public void delete(Time entity) {
        timeRepo.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        timeRepo.deleteAllById(longs);
    }

    @Override
    public void deleteAll(Iterable<? extends Time> entities) {
        timeRepo.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        timeRepo.deleteAll();
    }

    @Override
    public List<Time> findAll(Sort sort) {
        return timeRepo.findAll(sort);
    }

    @Override
    public Page<Time> findAll(Pageable pageable) {
        return timeRepo.findAll(pageable);
    }

    @Override
    public <S extends Time> Optional<S> findOne(Example<S> example) {
        return timeRepo.findOne(example);
    }

    @Override
    public <S extends Time> Page<S> findAll(Example<S> example, Pageable pageable) {
        return timeRepo.findAll(example, pageable);
    }

    @Override
    public <S extends Time> long count(Example<S> example) {
        return timeRepo.count(example);
    }

    @Override
    public <S extends Time> boolean exists(Example<S> example) {
        return timeRepo.exists(example);
    }

    @Override
    public <S extends Time, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return timeRepo.findBy(example, queryFunction);
    }

    @Override
    public Time findByPeriod(String period) {
        return timeRepo.findByPeriod(period);
    }

    @Override
    public Page<Time> findByPeriodContaining(String period, Pageable pageable) {
        return timeRepo.findByPeriodContaining(period, pageable);
    }



    @Override
    public void deleteTimeByPeriodAndDoctor(String period, Long doctorId) {
        timeRepo.deleteTimeByPeriodAndDoctor(period, doctorId);
    }
}
