package com.example.Ltnc.service.serviceImpl;

import com.example.Ltnc.model.domain.Doctor;
import com.example.Ltnc.model.repository.DoctorRepository;
import com.example.Ltnc.service.DoctorService;
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
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepo;

    @Override
    public void flush() {
        doctorRepo.flush();
    }

    @Override
    public <S extends Doctor> S saveAndFlush(S entity) {
        return doctorRepo.saveAndFlush(entity);
    }

    @Override
    public <S extends Doctor> List<S> saveAllAndFlush(Iterable<S> entities) {
        return doctorRepo.saveAllAndFlush(entities);
    }

    @Deprecated
    public void deleteInBatch(Iterable<Doctor> entities) {
        doctorRepo.deleteInBatch(entities);
    }

    @Override
    public void deleteAllInBatch(Iterable<Doctor> entities) {
        doctorRepo.deleteAllInBatch(entities);
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {
        doctorRepo.deleteAllByIdInBatch(longs);
    }

    @Override
    public void deleteAllInBatch() {
        doctorRepo.deleteAllInBatch();
    }

    @Override
    @Deprecated
    public Doctor getOne(Long aLong) {
        return doctorRepo.getOne(aLong);
    }

    @Override
    @Deprecated
    public Doctor getById(Long aLong) {
        return doctorRepo.getById(aLong);
    }

    @Override
    public Doctor getReferenceById(Long aLong) {
        return doctorRepo.getReferenceById(aLong);
    }

    @Override
    public <S extends Doctor> List<S> findAll(Example<S> example) {
        return doctorRepo.findAll(example);
    }

    @Override
    public <S extends Doctor> List<S> findAll(Example<S> example, Sort sort) {
        return doctorRepo.findAll(example, sort);
    }

    @Override
    public <S extends Doctor> List<S> saveAll(Iterable<S> entities) {
        return doctorRepo.saveAll(entities);
    }

    @Override
    public List<Doctor> findAll() {
        return doctorRepo.findAll();
    }

    @Override
    public List<Doctor> findAllById(Iterable<Long> longs) {
        return doctorRepo.findAllById(longs);
    }

    @Override
    public <S extends Doctor> S save(S entity) {
        return doctorRepo.save(entity);
    }

    @Override
    public Optional<Doctor> findById(Long aLong) {
        return doctorRepo.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return doctorRepo.existsById(aLong);
    }

    @Override
    public long count() {
        return doctorRepo.count();
    }

    @Override
    public void deleteById(Long aLong) {
        doctorRepo.deleteById(aLong);
    }

    @Override
    public void delete(Doctor entity) {
        doctorRepo.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        doctorRepo.deleteAllById(longs);
    }

    @Override
    public void deleteAll(Iterable<? extends Doctor> entities) {
        doctorRepo.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        doctorRepo.deleteAll();
    }

    @Override
    public List<Doctor> findAll(Sort sort) {
        return doctorRepo.findAll(sort);
    }

    @Override
    public Page<Doctor> findAll(Pageable pageable) {
        return doctorRepo.findAll(pageable);
    }

    @Override
    public <S extends Doctor> Optional<S> findOne(Example<S> example) {
        return doctorRepo.findOne(example);
    }

    @Override
    public <S extends Doctor> Page<S> findAll(Example<S> example, Pageable pageable) {
        return doctorRepo.findAll(example, pageable);
    }

    @Override
    public <S extends Doctor> long count(Example<S> example) {
        return doctorRepo.count(example);
    }

    @Override
    public <S extends Doctor> boolean exists(Example<S> example) {
        return doctorRepo.exists(example);
    }

    @Override
    public <S extends Doctor, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return doctorRepo.findBy(example, queryFunction);
    }

    @Override
    public Page<Doctor> findByNameContaining(String name, Pageable pageable) {
        return doctorRepo.findByNameContaining(name,pageable);
    }

    @Override
    public Doctor findByDoctorId(Long id) {
        return doctorRepo.findByDoctorId(id);
    }

    @Override
    public List<Doctor> getDoctorTime(String period, Long specialistId) {
        return doctorRepo.getDoctorTime(period, specialistId);
    }

    @Override
    public Doctor findByName(String name) {
        return doctorRepo.findByName(name);
    }


    @Override
    public void deleteDoctorByName(String name) {
        doctorRepo.deleteDoctorByName(name);
    }
}
