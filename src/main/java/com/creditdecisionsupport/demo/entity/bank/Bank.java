package com.creditdecisionsupport.demo.entity.bank;

import com.creditdecisionsupport.demo.entity.BankRegistration;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public abstract class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    private String foundationDate;
    private int tier;

    private int numberOfEmployees;

    private String founder;

    public double housingInterestRating;

    @JsonIgnore
    @OneToMany(mappedBy = "bank", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BankRegistration> registrationList;

}
