package com.teamwill.leasing.Service;

import java.util.List;

import com.teamwill.leasing.Entity.Product;

public interface ProductService extends ServiceAbstraction<Product> {
    public Long getTotal();

	List<Product> getAllProducts();

}
