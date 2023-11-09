package com.gofar.citzensws.entity;

import com.gofar.citzensws.utils.Blood;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Objects;

@Table(name = "citz")
@Entity
@Getter
@Setter
public class Citizen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cin", unique = true, nullable = false)
    private String cin;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mother_id", nullable = true)
    private Citizen mother;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "father_id", nullable = true)
    private Citizen father;
    @Column(name = "height")
    private Double height;
    @Column(name = "birth")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDay;
    @Column(name = "blood")
    @Enumerated(value = EnumType.STRING)
    private Blood group;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "job_id")
    private Job job;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Citizen citizen = (Citizen) o;
        return cin.equals(citizen.cin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cin);
    }
}
