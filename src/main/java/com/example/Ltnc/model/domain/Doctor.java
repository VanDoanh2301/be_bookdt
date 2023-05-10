package com.example.Ltnc.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Table(name = "doctor")
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctorId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "avatar", nullable = false)
    private String avatar;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone")
    private String phone;


    @Column(name = "day")
    private String day;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = {"doctors", "handler","hibernateLazyInitializer"}, allowSetters = true)
    @JoinColumn(name = "specialistId")
    private Specialist specialist;

    @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Collection<Time> times;

    @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Collection<Appointment>  appointments;

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Specialist getSpecialist() {
        return specialist;
    }

    public void setSpecialist(Specialist specialist) {
        this.specialist = specialist;
    }

    public void setTimes(Collection<Time> times) {
        this.times = times;
    }

    public void setAppointments(Collection<Appointment> appointments) {
        this.appointments = appointments;
    }
}
