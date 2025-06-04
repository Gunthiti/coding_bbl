package com.gun.demo.dto;

import com.gun.demo.entity.Address;
import com.gun.demo.entity.Company;
import lombok.Data;

@Data
public class UserDto {
    private String name;
    private String username;
    private String email;
    private AddressDto address;
    private String phone;
    private String website;
    private CompanyDto company;
}
