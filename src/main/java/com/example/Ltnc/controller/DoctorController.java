package com.example.Ltnc.controller;

import com.example.Ltnc.model.domain.Doctor;
import com.example.Ltnc.model.domain.Specialist;
import com.example.Ltnc.model.domain.Time;
import com.example.Ltnc.model.repository.DoctorRepository;
import com.example.Ltnc.service.DoctorService;
import com.example.Ltnc.service.SpecialistService;
import com.example.Ltnc.service.dto.DoctorDto;
import com.example.Ltnc.service.dto.TimeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @Autowired
    private SpecialistService specialistService;

    @Autowired
    private DoctorRepository doctorRepo;

    //Get all doctor
    @GetMapping("/doctors")
    public  ResponseEntity<?> getAllDoctor(@RequestParam(value = "name",required = false) String name
            ,@RequestParam(value = "page") Optional<Integer> page
            ,@RequestParam("size") Optional<Integer> size) {

        int currentPage = page.orElse(0);
        int pageSize = size.orElse(30);

        Pageable pageable = PageRequest.of(currentPage, pageSize, Sort.by("name"));
        Page<Doctor> resultPage = null;
        if (StringUtils.hasText(name)) {
            resultPage = doctorService.findByNameContaining(name, pageable);

        } else {
            resultPage = doctorService.findAll(pageable);
        }
        return ResponseEntity.ok(resultPage);
    }
    //Get doctor by id
    @GetMapping("/doctors/{id}")
    public ResponseEntity<?> getDoctorById(@PathVariable(name = "id") Long id) {
        Optional<Doctor> doctor = doctorService.findById(id);
        if (doctor.isEmpty()) {
            return ResponseEntity.ok("Null");
        }
        return ResponseEntity.ok(doctor);
    }

    @GetMapping("/doctors/times")
    public ResponseEntity<?> findDoctorsByPeriodAndSpecialist(
            @RequestParam(name = "period") String period,
            @RequestParam(name = "specialistId") Long specialistId) {
        List<Doctor> doctors = doctorService.getDoctorTime(period, specialistId);
        if(doctors.isEmpty()) {
            return ResponseEntity.ok("Null");
        }
        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }

    @PostMapping("/newDoctor")
    public ResponseEntity<?> newDoctor(@RequestBody DoctorDto doctorDto) {
        Specialist specialist = specialistService.findBySpecialistId(doctorDto.getSpecialistId());
        if (specialist == null) {
            return ResponseEntity.badRequest().body("Specialist not found");
        }

        Doctor existingDoctor = doctorRepo.findByEmail(doctorDto.getEmail());
        if (existingDoctor != null) {
            // Update existing doctor's information
            existingDoctor.setName(doctorDto.getName());
            existingDoctor.setAvatar(doctorDto.getAvatar());
            existingDoctor.setDay(doctorDto.getDay());
            existingDoctor.setPhone(doctorDto.getPhone());
            existingDoctor.setSpecialist(specialist);
            // No need to update doctorId, as it's used as an identifier
            doctorService.save(existingDoctor);
            return ResponseEntity.ok("Doctor updated successfully");
        }

        // Create a new doctor
        Doctor newDoctor = new Doctor();
        newDoctor.setDoctorId(doctorDto.getDoctorId());
        newDoctor.setName(doctorDto.getName());
        newDoctor.setAvatar(doctorDto.getAvatar());
        newDoctor.setDay(doctorDto.getDay());
        newDoctor.setPhone(doctorDto.getPhone());
        newDoctor.setSpecialist(specialist);
        newDoctor.setEmail(doctorDto.getEmail());
        doctorService.save(newDoctor);
        return ResponseEntity.ok("Doctor created successfully");
    }

    @DeleteMapping("doctors/{name}")
    public ResponseEntity<?> removeDoctorName(@PathVariable(name = "name") String name) {
        Doctor doctor = doctorService.findByName(name);
        if (doctor == null) {
            return ResponseEntity.ok("Null");
        }
        doctorService.delete(doctor);
        return ResponseEntity.ok("delete success");
    }


}
