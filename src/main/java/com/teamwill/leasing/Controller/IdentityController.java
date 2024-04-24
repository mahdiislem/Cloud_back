package com.teamwill.leasing.Controller;

import com.teamwill.leasing.Dto.IdentityDto;
import com.teamwill.leasing.Dto.ProductDto;
import com.teamwill.leasing.Entity.Identity;
import com.teamwill.leasing.Entity.Product;
import com.teamwill.leasing.Mapper.IdentityMapper;
import com.teamwill.leasing.Mapper.ProductMapper;
import com.teamwill.leasing.Service.IdentityService;
import com.teamwill.leasing.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/identities")
public class IdentityController {
    @Autowired
    IdentityService identityService;
    @Autowired
    IdentityMapper IdentityMapper;
    @PostMapping
    public ResponseEntity<?> add(@RequestBody IdentityDto identityDto) {
        Identity identity= IdentityMapper.IdentityDtoToIdentity(identityDto);
        return new ResponseEntity<>(identityService.add(identity), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Identity identity,@PathVariable("id") Long id) {
        return new ResponseEntity<>(identityService.update(identity,id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAll(@RequestParam(defaultValue = "0") Integer pageNo,
                                    @RequestParam(defaultValue = "10") Integer pageSize,
                                    @RequestParam(defaultValue = "id") String sortBy) {
        return new ResponseEntity<>(identityService.getAll(pageNo,pageSize,sortBy), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Long id) {
        return new ResponseEntity<>(identityService.get(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        identityService.delete(id);
        return new ResponseEntity<>("identity deleted", HttpStatus.OK);
    }


}
