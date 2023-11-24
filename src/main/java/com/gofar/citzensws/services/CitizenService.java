package com.gofar.citzensws.services;

import com.gofar.citzensws.entity.Citizen;
import com.gofar.citzensws.repository.CitizenRepository;
import com.gofar.citzensws.utils.LocalDateXmlConverter;
import com.gofar.ws.BloodGroup;
import com.gofar.ws.GetCitizenInfoRequest;
import com.gofar.ws.GetCitizenInfoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CitizenService {

    private CitizenRepository citizenRepository;

    public GetCitizenInfoResponse getCitizenInfoResponse(GetCitizenInfoRequest request) throws Exception {
        GetCitizenInfoResponse response = new GetCitizenInfoResponse();

        Citizen citizen = citizenRepository.findByCin(request.getCni());

        com.gofar.ws.Citizen wsCitz = new com.gofar.ws.Citizen();
        wsCitz.setCni(citizen.getCin());
        wsCitz.setFirstName(citizen.getFirstName());
        wsCitz.setLastName(citizen.getLastName());
        BloodGroup bloodGroup = BloodGroup.fromValue(citizen.getGroup().name());

        wsCitz.setBirthDay(LocalDateXmlConverter.marshal(citizen.getBirthDay()));
        wsCitz.setHeight(citizen.getHeight());
        wsCitz.setBloodGroup(bloodGroup);
        if (citizen.isFatherPresent())
            wsCitz.setFatherName(citizen.getFather().getLastName() + " " + citizen.getFather().getFirstName());
        if (citizen.isMotherPresent())
            wsCitz.setMotherName(citizen.getMother().getLastName() + " " + citizen.getMother().getFirstName());
        wsCitz.setJob(citizen.getJob());
        response.setData(wsCitz);

        return response;
    }

    @Autowired
    public void setCitizenRepository(CitizenRepository citizenRepository) {
        this.citizenRepository = citizenRepository;
    }
}
