package com.gun.demo.model;

import com.gun.demo.entity.Address;
import com.gun.demo.entity.Company;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserRequest {

    @NotBlank(message = "name is required")
    private String name;

    @NotBlank(message = "username is required")
    private String username;
    @Email(message = "Invalid email format")
    private String email;

    private Address address;

    @Pattern(regexp = "^\\d{10}$", message = "phone must be 10 digits")
    private String phone;

    @Size(max = 50)
    private String website;
    private Company company;

}
