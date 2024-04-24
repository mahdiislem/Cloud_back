package com.teamwill.leasing.Controller;

import com.teamwill.leasing.Dto.ProductDto;
import com.teamwill.leasing.Dto.ProductTypeDto;
import com.teamwill.leasing.Entity.Product;
import com.teamwill.leasing.Entity.ProductType;
import com.teamwill.leasing.Mapper.ProductMapper;
import com.teamwill.leasing.Mapper.ProductTypeMapper;
import com.teamwill.leasing.Service.ProductService;
import com.teamwill.leasing.Service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product-types")
public class ProductTypeController {
    @Autowired
    ProductTypeService productTypeService;

    @Autowired
    ProductTypeMapper productTypeMapper;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody ProductTypeDto productTypeDto) {
        ProductType productType= productTypeMapper.ProductTypeDtoToProductType(productTypeDto);
        return new ResponseEntity<>(productTypeService.add(productType), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody ProductType productType,@PathVariable("id") Long id) {
        return new ResponseEntity<>(productTypeService.update(productType,id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAll(@RequestParam(defaultValue = "0") Integer pageNo,
                                @RequestParam(defaultValue = "10") Integer pageSize,
                                @RequestParam(defaultValue = "id") String sortBy) {
        return new ResponseEntity<>(productTypeService.getAll(pageNo,pageSize,sortBy), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Long id) {
        return new ResponseEntity<>(productTypeService.get(id), HttpStatus.OK);
    }
    @GetMapping("/{id}/products")
    public ResponseEntity<?> getProducts(@PathVariable("id") Long id) {
        return new ResponseEntity<>(productTypeService.getProducts(id), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        productTypeService.delete(id);
        return new ResponseEntity<>("Product type deleted", HttpStatus.OK);
    }

}
