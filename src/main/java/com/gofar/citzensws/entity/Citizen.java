package com.gofar.citzensws.entity;

import com.gofar.citzensws.utils.Blood;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Citizen {

    private Long id;
    private String cin;
    private String firstName;
    private String lastName;
    private Citizen mother;
    private Citizen father;
    private Double height;
    private LocalDate birthDay;
    private boolean isFatherPresent = true;
    private boolean isMotherPresent = true;
    private Blood group;
    private String job;
}
