package com.example.Ltnc.controller;

import com.example.Ltnc.model.domain.Doctor;
import com.example.Ltnc.model.domain.Specialist;
import com.example.Ltnc.model.domain.Time;
import com.example.Ltnc.service.DoctorService;
import com.example.Ltnc.service.TimeService;
import com.example.Ltnc.service.dto.SpecialistDto;
import com.example.Ltnc.service.dto.TimeDto;
import lombok.extern.java.Log;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/auth/")
public class TimeController {
    @Autowired
    private TimeService timeService;

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/times")
    public ResponseEntity<?> getAllDoctor(@RequestParam(value = "period",required = false) String period
            , @RequestParam(value = "page") Optional<Integer> page
            , @RequestParam("size") Optional<Integer> size) {

        int currentPage = page.orElse(0);
        int pageSize = size.orElse(30);

        Pageable pageable = PageRequest.of(currentPage, pageSize, Sort.by("period"));
        Page<Time> resultPage = null;
        if (StringUtils.hasText(period)) {
            resultPage = timeService.findByPeriodContaining(period, pageable);

        } else {
            resultPage = timeService.findAll(pageable);
        }
        return ResponseEntity.ok(resultPage);
    }

    @PostMapping("/newTime")
    public ResponseEntity<?> newTime(@RequestBody TimeDto timeDto) {

        Doctor doctor = doctorService.findByDoctorId(timeDto.getDoctoId());
        if(doctor == null) {
            return ResponseEntity.badRequest().body("doctor is null");
        }
         Time  time = new Time();
         time.setTimeId(timeDto.getTimeId());
         time.setPeriod(timeDto.getPeriod());
         time.setDoctor(doctor);
         timeService.save(time);
        return ResponseEntity.ok("successfully");
    }

    @DeleteMapping("times/{period}")
    public ResponseEntity<?> removeSpecialName(@PathVariable(name = "period") String period) {
        Time time = timeService.findByPeriod(period);
        if (time == null) {
            return ResponseEntity.ok("Null");
        }
        timeService.deleteTimeByPeriodAndDoctor(period, time.getDoctor().getDoctorId());
        return ResponseEntity.ok("delete success");
    }
}
