package com.example.Ltnc.controller;

import com.example.Ltnc.model.domain.Doctor;
import com.example.Ltnc.model.domain.Specialist;
import com.example.Ltnc.model.domain.Time;
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
            return ResponseEntity.badRequest().body("specialist is null");
        }
        Doctor doctor = new Doctor();
        doctor.setDoctorId(doctorDto.getDoctorId());
        doctor.setName(doctorDto.getName());
        doctor.setAvatar(doctorDto.getAvatar());
        doctor.setDay(doctorDto.getDay());
        doctor.setPhone(doctorDto.getPhone());
        doctor.setSpecialist(specialist);
        doctor.setEmail(doctorDto.getEmail());
        doctorService.save(doctor);
        return ResponseEntity.ok("successfully");
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
