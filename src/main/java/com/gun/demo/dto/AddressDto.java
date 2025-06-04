package com.gun.demo.dto;

import com.gun.demo.entity.Geo;
import lombok.Data;

@Data
public class AddressDto {
    private String street;
    private String suite;
    private String city;
    private String zipcode;

    private GeoDto geo;
}
