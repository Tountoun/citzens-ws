package com.gofar.citzensws.repository;

import com.gofar.citzensws.entity.Citizen;
import com.gofar.citzensws.utils.CitizenRowMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Repository
public class CitizenRepository  {
    private JdbcTemplate jdbcTemplate;
    private static final String SELECT_CITZS_QUERY = "select * from citz c join job j on j.id = c.job_id where cin=? ;";
    private static final String SELECT_PARENT_NAME = "select concat(first_name, ' ', last_name) as full_name from citz where id=?;";

    @Transactional
    public Citizen findByCin(String cin) {
        Citizen ct = new Citizen();
        try {
            ct = jdbcTemplate.queryForObject(SELECT_CITZS_QUERY, new CitizenRowMapper(), cin);
        } catch (Exception e) {
            throw new EntityNotFoundException("No citizen with cin " + cin + " found");
        }
        Objects.requireNonNull(ct);
        if (ct.getFather().getId() != 0) {
            String fatherFullName = getParentName(ct.getFather().getId());
            ct.getFather().setFirstName(fatherFullName.split(" ")[0]);
            ct.getFather().setLastName(fatherFullName.split(" ")[1]);
        } else {
            ct.setFatherPresent(false);
        }
        if (ct.getMother().getId() != 0) {
            String motherFullName = getParentName(ct.getMother().getId());
            ct.getMother().setFirstName(motherFullName.split(" ")[0]);
            ct.getMother().setLastName(motherFullName.split(" ")[1]);
        } else {
            ct.setMotherPresent(false);
        }
        return ct;
    }
    private String getParentName(Long id) {
        return Objects.requireNonNull(jdbcTemplate.queryForObject(SELECT_PARENT_NAME, String.class, id));
    }
    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
