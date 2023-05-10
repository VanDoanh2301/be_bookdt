package com.example.Ltnc.service;

import com.example.Ltnc.model.domain.Doctor;
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
public interface DoctorService {
    void flush();

    <S extends Doctor> S saveAndFlush(S entity);

    <S extends Doctor> List<S> saveAllAndFlush(Iterable<S> entities);

    void deleteAllInBatch(Iterable<Doctor> entities);

    void deleteAllByIdInBatch(Iterable<Long> longs);

    void deleteAllInBatch();

    @Deprecated
    Doctor getOne(Long aLong);

    @Deprecated
    Doctor getById(Long aLong);

    Doctor getReferenceById(Long aLong);

    <S extends Doctor> List<S> findAll(Example<S> example);

    <S extends Doctor> List<S> findAll(Example<S> example, Sort sort);

    <S extends Doctor> List<S> saveAll(Iterable<S> entities);

    List<Doctor> findAll();

    List<Doctor> findAllById(Iterable<Long> longs);

    <S extends Doctor> S save(S entity);

    Optional<Doctor> findById(Long aLong);

    boolean existsById(Long aLong);

    long count();

    void deleteById(Long aLong);

    void delete(Doctor entity);

    void deleteAllById(Iterable<? extends Long> longs);

    void deleteAll(Iterable<? extends Doctor> entities);

    void deleteAll();

    List<Doctor> findAll(Sort sort);

    Page<Doctor> findAll(Pageable pageable);

    <S extends Doctor> Optional<S> findOne(Example<S> example);

    <S extends Doctor> Page<S> findAll(Example<S> example, Pageable pageable);

    <S extends Doctor> long count(Example<S> example);

    <S extends Doctor> boolean exists(Example<S> example);

    <S extends Doctor, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);

    Page<Doctor> findByNameContaining(String name, Pageable pageable);

    Doctor findByDoctorId(Long id);

    List<Doctor> getDoctorTime(String period, Long specialistId);

    Doctor findByName(String name);

    void deleteDoctorByName(String name);
}
