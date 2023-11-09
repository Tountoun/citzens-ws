package com.gofar.citzensws.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "job", uniqueConstraints = {@UniqueConstraint(columnNames = {"name", "domain"})})
@Getter
@Setter
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "domain", nullable = false)
    private String domain;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return name.equals(job.name) && domain.equals(job.domain);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, domain);
    }
}
