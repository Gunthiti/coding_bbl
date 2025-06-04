package com.gun.demo.mapper;

import com.gun.demo.dto.AddressDto;
import com.gun.demo.dto.CompanyDto;
import com.gun.demo.dto.GeoDto;
import com.gun.demo.dto.UserDto;
import com.gun.demo.entity.Address;
import com.gun.demo.entity.Company;
import com.gun.demo.entity.Geo;
import com.gun.demo.entity.User;
import com.gun.demo.model.CreateUserRequest;
import org.springframework.stereotype.Component;

import java.nio.channels.UnsupportedAddressTypeException;

@Component
public class UserMapper {
    public UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setName(user.getName());
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());

        AddressDto addressDto = new AddressDto();
        addressDto.setStreet(user.getAddress().getStreet());
        addressDto.setCity(user.getAddress().getCity());
        addressDto.setSuite(user.getAddress().getSuite());
        addressDto.setZipcode(user.getAddress().getZipcode());

        GeoDto geoDto = new GeoDto();
        geoDto.setLat(user.getAddress().getGeo().getLat());
        geoDto.setLng(user.getAddress().getGeo().getLng());
        addressDto.setGeo(geoDto);

        userDto.setAddress(addressDto);
        userDto.setPhone(user.getPhone());
        userDto.setWebsite(user.getWebsite());

        CompanyDto companyDto = new CompanyDto();
        companyDto.setName(user.getCompany().getName());
        companyDto.setCatchPhrase(user.getCompany().getCatchPhrase());
        companyDto.setBs(user.getCompany().getBs());
        userDto.setCompany(companyDto);
        return userDto;
    }

    public User toEntity(CreateUserRequest request) {
        User entity = new User();
        entity.setName(request.getName());
        entity.setUsername(request.getUsername());
        entity.setEmail(request.getEmail());

        Address address = new Address();
        address.setStreet(request.getAddress().getStreet());
        address.setCity(request.getAddress().getCity());
        address.setSuite(request.getAddress().getSuite());
        address.setZipcode(request.getAddress().getZipcode());

        Geo geoDto = new Geo();
        geoDto.setLat(request.getAddress().getGeo().getLat());
        geoDto.setLng(request.getAddress().getGeo().getLng());
        address.setGeo(geoDto);

        entity.setAddress(address);
        entity.setPhone(request.getPhone());
        entity.setWebsite(request.getWebsite());

        Company company = new Company();
        company.setName(request.getCompany().getName());
        company.setCatchPhrase(request.getCompany().getCatchPhrase());
        company.setBs(request.getCompany().getBs());
        entity.setCompany(company);
        return entity;
    }

}
