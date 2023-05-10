package com.example.Ltnc.service.dto;

import com.example.Ltnc.model.domain.Doctor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeDto {

    private int timeId;

    private String period;

    private Long doctoId;
}
