package com.teamwill.leasing.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString

public class MaritalStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 30)
    private String language;
    @Column(length = 30)
    private String name;
    @JsonIgnore
    @OneToMany(mappedBy = "maritalStatus")
    private List<Client> clients;


}
