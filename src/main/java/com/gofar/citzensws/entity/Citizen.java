package com.gofar.citzensws.entity;

import com.gofar.citzensws.utils.Blood;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Table(name = "citz")
@Entity
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


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
