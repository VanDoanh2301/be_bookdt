package com.example.Ltnc.service.serviceImpl;

import com.example.Ltnc.model.domain.Specialist;
import com.example.Ltnc.model.repository.SpecialistRepository;
import com.example.Ltnc.service.SpecialistService;
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
public class SpecialistServiceImpl implements SpecialistService {
    @Autowired
    private SpecialistRepository specialistRepo;

    @Override
    public void flush() {
        specialistRepo.flush();
    }

    @Override
    public <S extends Specialist> S saveAndFlush(S entity) {
        return specialistRepo.saveAndFlush(entity);
    }

    @Override
    public <S extends Specialist> List<S> saveAllAndFlush(Iterable<S> entities) {
        return specialistRepo.saveAllAndFlush(entities);
    }

    @Override
    @Deprecated
    public void deleteInBatch(Iterable<Specialist> entities) {
        specialistRepo.deleteInBatch(entities);
    }

    @Override
    public void deleteAllInBatch(Iterable<Specialist> entities) {
        specialistRepo.deleteAllInBatch(entities);
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {
        specialistRepo.deleteAllByIdInBatch(longs);
    }

    @Override
    public void deleteAllInBatch() {
        specialistRepo.deleteAllInBatch();
    }

    @Override
    @Deprecated
    public Specialist getOne(Long aLong) {
        return specialistRepo.getOne(aLong);
    }

    @Override
    @Deprecated
    public Specialist getById(Long aLong) {
        return specialistRepo.getById(aLong);
    }

    @Override
    public Specialist getReferenceById(Long aLong) {
        return specialistRepo.getReferenceById(aLong);
    }

    @Override
    public <S extends Specialist> List<S> findAll(Example<S> example) {
        return specialistRepo.findAll(example);
    }

    @Override
    public <S extends Specialist> List<S> findAll(Example<S> example, Sort sort) {
        return specialistRepo.findAll(example, sort);
    }

    @Override
    public <S extends Specialist> List<S> saveAll(Iterable<S> entities) {
        return specialistRepo.saveAll(entities);
    }

    @Override
    public List<Specialist> findAll() {
        return specialistRepo.findAll();
    }

    @Override
    public List<Specialist> findAllById(Iterable<Long> longs) {
        return specialistRepo.findAllById(longs);
    }

    @Override
    public <S extends Specialist> S save(S entity) {
        return specialistRepo.save(entity);
    }

    @Override
    public Optional<Specialist> findById(Long aLong) {
        return specialistRepo.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return specialistRepo.existsById(aLong);
    }

    @Override
    public long count() {
        return specialistRepo.count();
    }

    @Override
    public void deleteById(Long aLong) {
        specialistRepo.deleteById(aLong);
    }

    @Override
    public void delete(Specialist entity) {
        specialistRepo.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        specialistRepo.deleteAllById(longs);
    }

    @Override
    public void deleteAll(Iterable<? extends Specialist> entities) {
        specialistRepo.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        specialistRepo.deleteAll();
    }

    @Override
    public List<Specialist> findAll(Sort sort) {
        return specialistRepo.findAll(sort);
    }

    @Override
    public Page<Specialist> findAll(Pageable pageable) {
        return specialistRepo.findAll(pageable);
    }

    @Override
    public <S extends Specialist> Optional<S> findOne(Example<S> example) {
        return specialistRepo.findOne(example);
    }

    @Override
    public <S extends Specialist> Page<S> findAll(Example<S> example, Pageable pageable) {
        return specialistRepo.findAll(example, pageable);
    }

    @Override
    public <S extends Specialist> long count(Example<S> example) {
        return specialistRepo.count(example);
    }

    @Override
    public <S extends Specialist> boolean exists(Example<S> example) {
        return specialistRepo.exists(example);
    }

    @Override
    public <S extends Specialist, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return specialistRepo.findBy(example, queryFunction);
    }

    @Override
    public Page<Specialist> findBySpecialistNameContaining(String specialistName, Pageable pageable) {
        return specialistRepo.findBySpecialistNameContaining(specialistName, pageable);
    }


    @Override
    public Boolean existsBySpecialistName(String name) {
        return specialistRepo.existsBySpecialistName(name);
    }

    @Override
    public Boolean existsBySign(String sign) {
        return specialistRepo.existsBySign(sign);
    }


    @Override
    public Specialist findBySpecialistId(Long doctorId) {
        return specialistRepo.findBySpecialistId(doctorId);
    }


    @Override
    public Specialist findBySpecialistName(String name) {
        return specialistRepo.findBySpecialistName(name);
    }


    @Override
    public void deleteSpecialistByName(String name) {
        specialistRepo.deleteSpecialistByName(name);
    }
}
