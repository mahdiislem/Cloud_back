package com.teamwill.leasing.Entity.ParamPM;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.teamwill.leasing.Entity.Client;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TblPmType")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TypePm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(length = 30)
    String name;
    @Column(length = 60)
    String longName;

    @JsonIgnore
    @OneToMany(mappedBy = "typePm")
    List<Client> clients;

}
