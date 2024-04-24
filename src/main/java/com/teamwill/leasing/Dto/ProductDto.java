package com.teamwill.leasing.Dto;

import com.teamwill.leasing.Entity.ProductType;
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
public class ProductDto {
    private Long id;
    private String name;
    private Date creationDate;
    private Long productTypeId;
    private String prix;
    private String modele;
    private String nbrPlace;
    private String energie;
    private String boite;
    private String description;


}
