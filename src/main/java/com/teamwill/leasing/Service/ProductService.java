package com.teamwill.leasing.Service;

import com.teamwill.leasing.Entity.Product;

public interface ProductService extends ServiceAbstraction<Product> {
    public Long getTotal();

}
