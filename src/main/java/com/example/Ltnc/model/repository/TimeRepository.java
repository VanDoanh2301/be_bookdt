package com.example.Ltnc.model.repository;

import com.example.Ltnc.model.domain.Doctor;
import com.example.Ltnc.model.domain.Time;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TimeRepository extends JpaRepository<Time, Long> {
    Page<Time> findByPeriodContaining(String period, Pageable pageable);


    Time findByPeriod(String period);


    @Query(value = "delete from time where period = ?1 and doctor_id = ?2", nativeQuery = true)
    @Transactional
    @Modifying
    void deleteTimeByPeriodAndDoctor(String period, Long doctorId);
}
