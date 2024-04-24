package com.teamwill.leasing.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddressDto {
    private Long id;
    private String address;
    private String city;
    private String region;
    private String PostalCode;
    private Long addressTypeId;

}
