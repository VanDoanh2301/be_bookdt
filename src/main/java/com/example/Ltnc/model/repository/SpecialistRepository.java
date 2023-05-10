package com.example.Ltnc.model.repository;

import com.example.Ltnc.model.domain.Specialist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface SpecialistRepository extends JpaRepository<Specialist, Long> {
    Page<Specialist> findBySpecialistNameContaining(String specialistName, Pageable pageable);

    Specialist  findBySpecialistId(Long doctorId);

    Specialist findBySpecialistName(String name);

    Boolean existsBySpecialistName(String name);
    Boolean existsBySign(String sign);

    @Query(value = "delete from specicalist where name=?1", nativeQuery = true)
    @Transactional
    @Modifying
    void deleteSpecialistByName(String name);
}
