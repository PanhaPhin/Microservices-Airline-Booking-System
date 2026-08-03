package com.panha.service;

import com.panha.payload.request.CityRequest;
import com.panha.payload.response.CityResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface CityService {

    CityResponse createCity(CityRequest request);

    CityResponse getCityById(Long id) throws Exception;

    CityResponse updateCity(Long id, CityRequest request) throws Exception;

    void deleteCity(Long id) throws Exception;

    Page<CityResponse> getAllCities(Pageable pageable);

    Page<CityResponse> searchCities(String keyword, Pageable pageable);

    Page<CityResponse> getCitiesByCountryCode(String countryCode, Pageable pageable);

    boolean cityExists(String cityCode);
}