package com.gofar.citzensws.utils;

import com.gofar.citzensws.entity.Citizen;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class CitizenRowMapper implements RowMapper<Citizen> {
    @Override
    public Citizen mapRow(ResultSet rs, int rowNum) throws SQLException {
        Citizen citizen = new Citizen();
        citizen.setCin(rs.getString("cin"));
        citizen.setHeight(rs.getDouble("height"));
        citizen.setFirstName(rs.getString("first_name"));
        citizen.setLastName(rs.getString("last_name"));
        citizen.setBirthDay(LocalDate.parse(rs.getString("birth")));
        citizen.setGroup(Blood.valueOf(rs.getString("blood")));
        citizen.setJob(rs.getString("name"));
        Citizen father = new Citizen();
        father.setId(rs.getLong("father_id"));
        Citizen mother = new Citizen();
        mother.setId(rs.getLong("father_id"));
        citizen.setFather(father);
        citizen.setMother(mother);
        return citizen;
    }
}
