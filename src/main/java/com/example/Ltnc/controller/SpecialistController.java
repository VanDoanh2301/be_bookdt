package com.example.Ltnc.controller;

import com.example.Ltnc.model.domain.*;
import com.example.Ltnc.service.SpecialistService;
import com.example.Ltnc.service.dto.SpecialistDto;
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
public class SpecialistController {

    @Autowired
    private SpecialistService specialistService;

    @GetMapping("/specialists")
    public ResponseEntity<?> getAllDoctor(@RequestParam(value = "specialistName",required = false) String specialistName
            , @RequestParam(value = "page") Optional<Integer> page
            , @RequestParam("size") Optional<Integer> size) {

        int currentPage = page.orElse(0);
        int pageSize = size.orElse(30);

        Pageable pageable = PageRequest.of(currentPage, pageSize, Sort.by("specialistName"));
        Page<Specialist> resultPage = null;
        if (StringUtils.hasText(specialistName)) {
            resultPage = specialistService.findBySpecialistNameContaining(specialistName, pageable);

        } else {
            resultPage = specialistService.findAll(pageable);
        }
        return ResponseEntity.ok(resultPage);
    }

    @PostMapping("/newSpecial")
    public ResponseEntity<?> newSpecialist(@RequestBody SpecialistDto specialistDto) {
        Specialist specialist = new Specialist();
        if (specialistService.existsBySpecialistName(specialistDto.getSpecialistName())) {
            return ResponseEntity.badRequest().body("Name is adreadly");
        }
        if (specialistService.existsBySign(specialistDto.getSign())) {
            return ResponseEntity.badRequest().body("Sign is adreadly");
        }
        BeanUtils.copyProperties(specialistDto, specialist);
        specialistService.save(specialist);
        return ResponseEntity.ok("successfully");
    }

    @DeleteMapping("specialists/{name}")
    public ResponseEntity<?> removeSpecialName(@PathVariable(name = "name") String name) {
        Specialist specialist = specialistService.findBySpecialistName(name);
        if (specialist == null) {
            return ResponseEntity.ok("Null");
        }
        specialistService.delete(specialist);
        return ResponseEntity.ok("delete success");
    }

}
