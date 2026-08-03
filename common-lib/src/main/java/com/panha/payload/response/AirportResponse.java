package com.panha.payload.response;

import com.panha.embeddable.Address;
import com.panha.embeddable.GeoCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZoneId;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AirportResponse {

    private Long id;
    private String iataCode;
    private String name;
    private String detailedName;
    private String timezone;
    private Address address;
    private CityResponse city;
    private GeoCode geoCode;

}
