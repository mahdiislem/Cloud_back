package com.teamwill.leasing.Service;

import com.teamwill.leasing.Entity.Product;
import com.teamwill.leasing.Entity.ProductType;

import java.util.List;

public interface ProductTypeService extends ServiceAbstraction<ProductType> {
    public List<Product> getProducts(Long id);
}
