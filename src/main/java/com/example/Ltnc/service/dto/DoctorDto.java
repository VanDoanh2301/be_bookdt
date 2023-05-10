package com.example.Ltnc.service.dto;

import com.example.Ltnc.model.domain.Specialist;
import com.example.Ltnc.model.domain.Time;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDto {

    private Long doctorId;

    private String name;

    private String avatar;

    private String email;

    private String phone;

    private String day;

    private Long specialistId;

}
