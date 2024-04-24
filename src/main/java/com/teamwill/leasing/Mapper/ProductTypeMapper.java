package com.teamwill.leasing.Mapper;

import com.teamwill.leasing.Dto.ProductDto;
import com.teamwill.leasing.Dto.ProductTypeDto;
import com.teamwill.leasing.Entity.Product;
import com.teamwill.leasing.Entity.ProductType;
import com.teamwill.leasing.Repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductTypeMapper {
    @Autowired
    ProductTypeRepository productTypeRepository;

    public ProductType ProductTypeDtoToProductType(ProductTypeDto productTypeDto){
        ProductType productType =new ProductType();
        productType.setName(productTypeDto.getName());
        productType.setId(productTypeDto.getId());
        return productType;
    }
}
