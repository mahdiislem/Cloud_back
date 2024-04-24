package com.teamwill.leasing.Controller;

import com.teamwill.leasing.Dto.ProductDto;
import com.teamwill.leasing.Entity.Product;
import com.teamwill.leasing.Mapper.ProductMapper;
import com.teamwill.leasing.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    ProductMapper productMapper;
    @PostMapping
    public ResponseEntity<?> add(@RequestBody ProductDto productDto) {
        Product product= productMapper.ProductDtoToProduct(productDto);
        return new ResponseEntity<>(productService.add(product), HttpStatus.OK);
    }
    @GetMapping("/get-total")
    public ResponseEntity<?> getTotal() {
        return new ResponseEntity<>(productService.getTotal(), HttpStatus.OK);
    }



    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Product product,@PathVariable("id") Long id) {
        return new ResponseEntity<>(productService.update(product,id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAll(@RequestParam(defaultValue = "0") Integer pageNo,
                                @RequestParam(defaultValue = "10") Integer pageSize,
                                @RequestParam(defaultValue = "id") String sortBy) {
        return new ResponseEntity<>(productService.getAll(pageNo,pageSize,sortBy), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Long id) {
        return new ResponseEntity<>(productService.get(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        productService.delete(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }
}
