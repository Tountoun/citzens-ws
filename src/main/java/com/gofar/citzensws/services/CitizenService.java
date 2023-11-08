package com.gofar.citzensws.services;

import com.gofar.citzensws.utils.Data;
import com.gofar.ws.Citizen;
import com.gofar.ws.GetCitizenInfoRequest;
import com.gofar.ws.GetCitizenInfoResponse;
import org.springframework.stereotype.Service;

@Service
public class CitizenService {

    public GetCitizenInfoResponse getCitizenInfoResponse(GetCitizenInfoRequest request) throws Exception {
        GetCitizenInfoResponse response = new GetCitizenInfoResponse();

        Citizen citizen = Data.citizens().stream()
                .filter(citizen1 -> citizen1.getCni().equals(request.getCni()))
                .findFirst().orElse(null);
        response.setData(citizen);
        return response;
    }

}
