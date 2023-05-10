package com.example.Ltnc;


import com.example.Ltnc.model.domain.Doctor;
import com.example.Ltnc.model.repository.DoctorRepository;
import com.example.Ltnc.model.repository.TimeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
class LtncApplicationTests {
    @Autowired
    private TimeRepository timeRepository;
    @Test
    void contextLoads() throws ParseException {


    }

}