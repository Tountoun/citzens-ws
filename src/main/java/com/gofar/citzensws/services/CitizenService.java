package com.gofar.citzensws.services;

import com.gofar.citzensws.entity.Citizen;
import com.gofar.citzensws.repository.CitizenRepository;
import com.gofar.citzensws.utils.LocalDateXmlConverter;
import com.gofar.ws.GetCitizenInfoRequest;
import com.gofar.ws.GetCitizenInfoResponse;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CitizenService {

    private CitizenRepository citizenRepository;

    public GetCitizenInfoResponse getCitizenInfoResponse(GetCitizenInfoRequest request) throws Exception {
        GetCitizenInfoResponse response = new GetCitizenInfoResponse();

        Citizen citizen = citizenRepository.findByCin(request.getCni()).orElseThrow(EntityNotFoundException::new);
        com.gofar.ws.Citizen wsCitz = new com.gofar.ws.Citizen();
        wsCitz.setCni(citizen.getCin());
        wsCitz.setFirstName(citizen.getFirstName());
        wsCitz.setLastName(citizen.getLastName());
        wsCitz.setBirthDay(LocalDateXmlConverter.marshal(citizen.getBirthDay()));
        wsCitz.setHeight(citizen.getHeight());
        String mother = "";
        String father = "";
        if (Objects.nonNull(citizen.getMother())) {
            mother = citizen.getMother().getLastName() + " " + citizen.getMother().getFirstName();
        }
        if (Objects.nonNull(citizen.getFather())) {
            father = citizen.getFather().getLastName() + " " + citizen.getFather().getFirstName();
        }
        wsCitz.setFatherName(father);
        wsCitz.setMotherName(mother);
        wsCitz.setJob(citizen.getJob().getName());
        response.setData(wsCitz);

        return response;
    }

    @Autowired
    public void setCitizenRepository(CitizenRepository citizenRepository) {
        this.citizenRepository = citizenRepository;
    }
}
