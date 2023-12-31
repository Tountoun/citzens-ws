package com.gofar.citzensws.endpoint;

import com.gofar.citzensws.services.CitizenService;
import com.gofar.ws.GetCitizenInfoRequest;
import com.gofar.ws.GetCitizenInfoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CitizenEndpoint {
    private static final String NAMESPACE = "http://gofar.com/ws";

    private CitizenService citizenService;

    @PayloadRoot(localPart = "getCitizenInfoRequest", namespace = NAMESPACE)
    @ResponsePayload
    public GetCitizenInfoResponse getCitizenInfoRequest(@RequestPayload GetCitizenInfoRequest request) {
        GetCitizenInfoResponse response = null;
        try {
            response = citizenService.getCitizenInfoResponse(request);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    @Autowired
    public void setCitizenService(CitizenService citizenService) {
        this.citizenService = citizenService;
    }
}
