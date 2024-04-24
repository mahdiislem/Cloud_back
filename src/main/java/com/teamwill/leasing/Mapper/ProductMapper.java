package com.teamwill.leasing.Mapper;

import com.teamwill.leasing.Dto.ProductDto;
import com.teamwill.leasing.Entity.Product;
import com.teamwill.leasing.Entity.ProductType;
import com.teamwill.leasing.Repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {
    @Autowired
    ProductTypeRepository productTypeRepository;

    public Product ProductDtoToProduct(ProductDto productDto){
        Product product =new Product();
        product.setName(productDto.getName());
        product.setId(productDto.getId());
        product.setPrix(productDto.getPrix());
        product.setBoite(productDto.getBoite());
        product.setDescription(productDto.getDescription());
        product.setEnergie(productDto.getEnergie());
        product.setModele(productDto.getModele());
        product.setNbrPlace(productDto.getNbrPlace());
        if(productDto.getProductTypeId()!=null){
            ProductType productType=productTypeRepository.findById(productDto.getProductTypeId()).orElseThrow(()->new IllegalArgumentException("No product type with id ="+productDto.getProductTypeId()));
            product.setProductType(productType);
        }
        return product;
    }
}
