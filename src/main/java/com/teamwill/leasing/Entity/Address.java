package com.teamwill.leasing.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 60)
    private String address;
    @Column(length = 20)
    private String city;
    @Column(length = 30)
    private String region;
    @Column(length = 4)
    private String PostalCode;

    @ManyToOne
    private Client client;


}
