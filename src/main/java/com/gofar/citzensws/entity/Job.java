package com.gofar.citzensws.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "job", uniqueConstraints = {@UniqueConstraint(columnNames = {"name", "domain"})})
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "domain", nullable = false)
    private String domain;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

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
