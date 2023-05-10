package com.example.Ltnc.service;

import com.example.Ltnc.model.domain.Time;
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
public interface TimeService {
    void flush();

    <S extends Time> S saveAndFlush(S entity);

    <S extends Time> List<S> saveAllAndFlush(Iterable<S> entities);

    @Deprecated
    void deleteInBatch(Iterable<Time> entities);

    void deleteAllInBatch(Iterable<Time> entities);

    void deleteAllByIdInBatch(Iterable<Long> longs);

    void deleteAllInBatch();

    @Deprecated
    Time getOne(Long aLong);

    @Deprecated
    Time getById(Long aLong);

    Time getReferenceById(Long aLong);

    <S extends Time> List<S> findAll(Example<S> example);

    <S extends Time> List<S> findAll(Example<S> example, Sort sort);

    <S extends Time> List<S> saveAll(Iterable<S> entities);

    List<Time> findAll();

    List<Time> findAllById(Iterable<Long> longs);

    <S extends Time> S save(S entity);

    Optional<Time> findById(Long aLong);

    boolean existsById(Long aLong);

    long count();

    void deleteById(Long aLong);

    void delete(Time entity);

    void deleteAllById(Iterable<? extends Long> longs);

    void deleteAll(Iterable<? extends Time> entities);

    void deleteAll();

    List<Time> findAll(Sort sort);

    Page<Time> findAll(Pageable pageable);

    <S extends Time> Optional<S> findOne(Example<S> example);

    <S extends Time> Page<S> findAll(Example<S> example, Pageable pageable);

    <S extends Time> long count(Example<S> example);

    <S extends Time> boolean exists(Example<S> example);

    <S extends Time, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);

    Time findByPeriod(String period);

    Page<Time> findByPeriodContaining(String period, Pageable pageable);

    void deleteTimeByPeriodAndDoctor(String period, Long doctorId);
}
