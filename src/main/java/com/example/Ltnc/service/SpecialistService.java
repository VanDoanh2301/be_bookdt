package com.example.Ltnc.service;

import com.example.Ltnc.model.domain.Specialist;
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
public interface SpecialistService {
    void flush();

    <S extends Specialist> S saveAndFlush(S entity);

    <S extends Specialist> List<S> saveAllAndFlush(Iterable<S> entities);

    @Deprecated
    void deleteInBatch(Iterable<Specialist> entities);

    void deleteAllInBatch(Iterable<Specialist> entities);

    void deleteAllByIdInBatch(Iterable<Long> longs);

    void deleteAllInBatch();

    @Deprecated
    Specialist getOne(Long aLong);

    @Deprecated
    Specialist getById(Long aLong);

    Specialist getReferenceById(Long aLong);

    <S extends Specialist> List<S> findAll(Example<S> example);

    <S extends Specialist> List<S> findAll(Example<S> example, Sort sort);

    <S extends Specialist> List<S> saveAll(Iterable<S> entities);

    List<Specialist> findAll();

    List<Specialist> findAllById(Iterable<Long> longs);

    <S extends Specialist> S save(S entity);

    Optional<Specialist> findById(Long aLong);

    boolean existsById(Long aLong);

    long count();

    void deleteById(Long aLong);

    void delete(Specialist entity);

    void deleteAllById(Iterable<? extends Long> longs);

    void deleteAll(Iterable<? extends Specialist> entities);

    void deleteAll();

    List<Specialist> findAll(Sort sort);

    Page<Specialist> findAll(Pageable pageable);

    <S extends Specialist> Optional<S> findOne(Example<S> example);

    <S extends Specialist> Page<S> findAll(Example<S> example, Pageable pageable);

    <S extends Specialist> long count(Example<S> example);

    <S extends Specialist> boolean exists(Example<S> example);

    <S extends Specialist, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);

    Page<Specialist> findBySpecialistNameContaining(String specialistName, Pageable pageable);

    Boolean existsBySpecialistName(String name);

    Boolean existsBySign(String sign);

    Specialist findBySpecialistId(Long doctorId);

    Specialist findBySpecialistName(String name);

    void deleteSpecialistByName(String name);
}
