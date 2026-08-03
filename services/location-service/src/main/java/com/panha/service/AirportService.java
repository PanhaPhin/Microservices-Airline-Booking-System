package com.panha.service;



import com.panha.payload.request.AirportRequest;
import com.panha.payload.response.AirportResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AirportService {

    AirportResponse createAirport (AirportRequest request) throws Exception;
    AirportResponse getAirportById (Long id) throws Exception;

    List<AirportResponse> getAllAirports();

    AirportResponse updateAirport(Long id , AirportRequest request) throws Exception;
    void deleteAirport(Long id) throws Exception;
    List<AirportResponse> getAirportByCityId(Long cityId);
}
