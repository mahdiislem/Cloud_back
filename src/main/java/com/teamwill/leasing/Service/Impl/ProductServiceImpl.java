package com.teamwill.leasing.Service.Impl;

import com.teamwill.leasing.Entity.Fournisseur;
import com.teamwill.leasing.Entity.Product;
import com.teamwill.leasing.Repository.ProductRepository;
import com.teamwill.leasing.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;


    @Override
    public Product update(Product product,Long id) {
        Product p=productRepository.findById(id).orElseThrow(()->new IllegalArgumentException("No product with id "+id));
        p.setName(product.getName());
        p.setNbrPlace(product.getNbrPlace());
        p.setModele(product.getModele());
        p.setPrix(product.getPrix());
        p.setEnergie(product.getEnergie());
        p.setDescription(product.getDescription());
        return productRepository.save(p);
    }

    @Override
    public List<Product> getAll(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<Product> pagedResult = productRepository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<>();
        }
    }
    @Override
    public List<Product> getAllProducts() {

        List<Product>products= (List<Product>) productRepository.findAll();
        return products;

    }

    @Override
    public Product get(Long id) {
        return productRepository.findById(id).orElseThrow(()->new IllegalArgumentException("No product with id "+id));
    }
    @Override
    public Product add(Product pro) {
        Product product=productRepository.findByName(pro.getName());
        if(product!=null) throw new RuntimeException("produit already exists");
        //if(!us.equals(confirmedPassword)) throw new RuntimeException("Please confirm your password");
        pro.setIsDeleted(false);
        pro.setCreationDate(new Date());
        productRepository.save(pro);
        return pro;
    }

    @Override
    public void delete(Long id) {
        Product p=productRepository.findById(id).orElseThrow(()->new IllegalArgumentException("No product with id "+id));
        productRepository.delete(p);
    }

    @Override
    public Long getTotal() {
        return productRepository.countByIsDeletedEquals(false);
    }
}
