package com.teamwill.leasing.controller;

import com.teamwill.leasing.Controller.ProductController;
import com.teamwill.leasing.Dto.ProductDto;
import com.teamwill.leasing.Entity.Product;
import com.teamwill.leasing.Mapper.ProductMapper;
import com.teamwill.leasing.Repository.ProductRepository;
import com.teamwill.leasing.Service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ProductControllerTest {

    @Mock

    private ProductService productService;

    @Mock
    private ProductMapper productMapper;

    @InjectMocks
    private ProductController productController;
    
    @MockBean
    private ProductRepository repProducts;

    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }

    @Test
    void testAddProduct() throws Exception {
        ProductDto productDto = new ProductDto();
        Product product = new Product();
        when(productMapper.ProductDtoToProduct(any(ProductDto.class))).thenReturn(product);
        when(productService.add(any(Product.class))).thenReturn(product);

        mockMvc.perform(post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(productDto)))
                .andExpect(status().isOk());
    }

    @Test
    void testGetProductById() throws Exception {
        Product product = new Product();
        when(productService.get(anyLong())).thenReturn(product);

        mockMvc.perform(get("/products/{id}", 1L))
                .andExpect(status().isOk());
    }
    
    
    
    @Test
    void testGetAllProducts() throws Exception {
        when(productService.getAll(anyInt(), anyInt(), anyString())).thenReturn(List.of(new Product()));

        mockMvc.perform(get("/products")
                .param("pageNo", "0")
                .param("pageSize", "10")
                .param("sortBy", "id"))
                .andExpect(status().isOk());
    }

    @Test
    void testUpdateProduct() throws Exception {
        Product product = new Product();
        when(productService.update(any(Product.class), anyLong())).thenReturn(product);

        mockMvc.perform(put("/products/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(product)))
                .andExpect(status().isOk());
    }

    @Test
    void testDeleteProduct() throws Exception {
        mockMvc.perform(delete("/products/{id}", 1L))
                .andExpect(status().isOk());
    }
}
