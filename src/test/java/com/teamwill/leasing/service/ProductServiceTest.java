package com.teamwill.leasing.service;

import com.teamwill.leasing.Entity.Product;
import com.teamwill.leasing.Repository.ProductRepository;
import com.teamwill.leasing.Service.Impl.ProductServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddProduct() {
        Product product = new Product();
        when(productRepository.save(any(Product.class))).thenReturn(product);
        Product created = productService.add(product);
        assertNotNull(created);
        verify(productRepository, times(1)).save(product);
    }

    @Test
    void testGetProductById() {
        Product product = new Product();
        when(productRepository.findById(anyLong())).thenReturn(Optional.of(product));
        Product found = productService.get(1L);
        assertNotNull(found);
        verify(productRepository, times(1)).findById(1L);
    }

    @Test
    void testGetAllProducts() {
        // Create a product and put it in a list
        Product product = new Product();
        List<Product> products = Collections.singletonList(product);

        // Create a pageable object
        Pageable pageable = PageRequest.of(0, 10, Sort.by("id"));

        // Mock the repository to return a page of products
        Page<Product> pagedProducts = new PageImpl<>(products, pageable, products.size());
        when(productRepository.findAll(any(Pageable.class))).thenReturn(pagedProducts);

        // Call the service method
        List<Product> found = productService.getAll(0, 10, "id");

        // Verify that the service returns the correct number of products
        assertEquals(1, found.size());
        verify(productRepository, times(1)).findAll(any(Pageable.class));
    }

    @Test
    void testUpdateProduct() {
        Product product = new Product();
        when(productRepository.findById(anyLong())).thenReturn(Optional.of(product));
        when(productRepository.save(any(Product.class))).thenReturn(product);
        Product updated = productService.update(product, 1L);
        assertNotNull(updated);
        verify(productRepository, times(1)).findById(1L);
        verify(productRepository, times(1)).save(product);
    }

    @Test
    void testDeleteProduct() {
        // Mocking the repository to return a product when findById is called
        Product product = new Product();
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));

        // Mocking the delete method to do nothing (since it's void)
        doNothing().when(productRepository).delete(any(Product.class));

        // Calling the delete method of the service
        productService.delete(1L);

        // Verifying that findById and delete were called with the correct arguments
        verify(productRepository, times(1)).findById(1L);
        verify(productRepository, times(1)).delete(product);
    }

}
