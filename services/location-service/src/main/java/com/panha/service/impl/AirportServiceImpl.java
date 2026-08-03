package com.panha.service.impl;


import com.panha.Model.Airport;
import com.panha.Model.City;
import com.panha.mapper.AirportMapper;
import com.panha.payload.request.AirportRequest;
import com.panha.payload.response.AirportResponse;
import com.panha.repositoy.AirportRepository;
import com.panha.repositoy.CityRepository;
import com.panha.service.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class AirportServiceImpl implements AirportService {


    private final AirportRepository airportRepository;
    private final CityRepository cityRepository;

    @Override
    public AirportResponse createAirport(AirportRequest request) throws Exception {

            if(airportRepository.findByIataCode(request.getIataCode()).isPresent()){
               throw new Exception("Airport with Iata Code Already Exist") ;

            }

            City city = cityRepository.findById(request.getCityId())
                    .orElseThrow(() -> new Exception("city not found"));
            Airport airport = AirportMapper.toEntiy(request);
            airport.setCity(city);
            Airport savedAirport = airportRepository.save(airport);


        return AirportMapper.toResponse(savedAirport);
    }

    @Override
    public AirportResponse getAirportById(Long id) throws Exception {
        Airport airport = airportRepository.findById(id).orElseThrow(
                ()-> new Exception("airport not exist with provided id")
        );
        return AirportMapper.toResponse(airport);
    }

    @Override
    public List<AirportResponse> getAllAirports() {

        return airportRepository.findAll().stream()
                .map(AirportMapper::toResponse)
                .collect(Collectors.toList());


    }

    @Override
    public AirportResponse updateAirport(Long id, AirportRequest request) throws Exception {
        Airport existingAirport = airportRepository.findById(id).orElseThrow(
                ()-> new Exception("airport not exist with id"+ id)
        );
        if(request.getIataCode()!=null
                && !existingAirport.getIataCode().equals(request.getIataCode())
                && airportRepository.findByIataCode(request.getIataCode()).isPresent()

        ){
            throw new Exception("Airport with Iata code Already Exist");
        }
        AirportMapper.updateEntity(request , existingAirport);
        Airport updateAirport=airportRepository.save(existingAirport);
        return AirportMapper.toResponse(updateAirport);
    }

    @Override
    public void deleteAirport(Long id) throws Exception {
        Airport airport= airportRepository.findById(id).orElseThrow(
                ()-> new Exception("airport not exist with provided id")
        );
        airportRepository.delete(airport);

    }

    @Override
    public List<AirportResponse> getAirportByCityId(Long cityId) {

        return airportRepository.findByCityId(cityId).stream()
                .map(AirportMapper::toResponse)
                .collect(Collectors.toList());
    }
}
