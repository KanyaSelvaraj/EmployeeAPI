package com.corporate.employee.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@NoArgsConstructor
@Embeddable
public class Address {
    private String address1;
    private String address2;
    private String city;
    private String postCode;
}
