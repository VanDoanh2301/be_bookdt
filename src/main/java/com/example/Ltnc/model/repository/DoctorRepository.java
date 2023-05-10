package com.example.Ltnc.model.repository;

import com.example.Ltnc.model.domain.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Page<Doctor> findByNameContaining(String name, Pageable pageable);
    Doctor findByDoctorId(Long id);

    Doctor findByName(String name);

    @Query(value = "SELECT doctor.* FROM doctor JOIN specialist ON doctor.specialist_id = specialist.specialist_id JOIN time ON doctor.doctor_id = time.doctor_id WHERE time.period = ?1 AND specialist.specialist_id = ?2" , nativeQuery = true)
    List<Doctor> getDoctorTime(String period, Long specialistId);

    @Query(value = "delete from doctor where name = ?1", nativeQuery = true)
    @Transactional
    @Modifying
    void deleteDoctorByName(String name);


}
