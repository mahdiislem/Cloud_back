package com.teamwill.leasing.Dto;


import com.teamwill.leasing.Entity.Client;
import com.teamwill.leasing.Entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.ManyToOne;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DemandeCreditDto {
    private Long id;
    private String name;
    private String duree;
    private String nbrEcheance;
    private String demandeType;
    private Long productId;
    private Long clientId;

}
