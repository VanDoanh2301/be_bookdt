package com.example.Ltnc.model.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.print.Doc;
import java.util.Collection;
import java.util.List;
@Entity
@Data
@Table(name = "specialist")
@AllArgsConstructor
@NoArgsConstructor
public class Specialist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long specialistId;

    @Column(name = "name")
    private String specialistName;
    @Column(name = "sign")
    private String sign;

   @OneToMany(mappedBy = "specialist", cascade = CascadeType.ALL)
   private Collection<Doctor> doctors;

}
