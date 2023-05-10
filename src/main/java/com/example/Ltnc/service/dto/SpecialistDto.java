package com.example.Ltnc.service.dto;

import com.example.Ltnc.model.domain.Doctor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpecialistDto {

    private Long specialistId;
    private String specialistName;
    private String sign;
}
