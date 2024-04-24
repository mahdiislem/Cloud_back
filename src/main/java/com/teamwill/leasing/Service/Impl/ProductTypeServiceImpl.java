package com.teamwill.leasing.Service.Impl;

import com.teamwill.leasing.Entity.Product;
import com.teamwill.leasing.Entity.ProductType;
import com.teamwill.leasing.Repository.ProductTypeRepository;
import com.teamwill.leasing.Service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {
    @Autowired
    ProductTypeRepository productTypeRepository;
    @Override
    public ProductType add(ProductType productType) {
        return productTypeRepository.save(productType);
    }

    @Override
    public ProductType update(ProductType productType, Long id) {
        ProductType productType1=productTypeRepository.findById(id).orElseThrow(()->new IllegalArgumentException("No product type with id "+id));
        productType1.setName(productType.getName());
        return productTypeRepository.save(productType1);
    }

    @Override
    public List<ProductType> getAll(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<ProductType> pagedResult = productTypeRepository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public ProductType get(Long id) {
        return productTypeRepository.findById(id).orElseThrow(()->new IllegalArgumentException("No product type with id "+id));
    }

    @Override
    public void delete(Long id) {
        ProductType productType=productTypeRepository.findById(id).orElseThrow(()->new IllegalArgumentException("No product type with id "+id));
        productTypeRepository.delete(productType);
    }

    @Override
    public List<Product> getProducts(Long id) {
        ProductType productType=productTypeRepository.findById(id).orElseThrow(()->new IllegalArgumentException("No product type with id "+id));
        return productType.getProducts();
    }
}
