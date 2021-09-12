package com.creditdecisionsupport.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private long Id;

    @NotBlank(message = "Email is mandatory")
    @Pattern(regexp = "^(.+)@(.+)$")
    private String emailAddress;

    @NotBlank(message = "Phone Number is mandatory")
    @Pattern(regexp = "^[0-9]+$")
    private String phoneNumber;

    private String identityNumber;
}
