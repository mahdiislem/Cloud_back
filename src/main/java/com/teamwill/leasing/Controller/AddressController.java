package com.teamwill.leasing.Controller;

import com.teamwill.leasing.Dto.AddressDto;
import com.teamwill.leasing.Entity.Address;
import com.teamwill.leasing.Mapper.AddressMapper;
import com.teamwill.leasing.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addresses")
public class AddressController {
    @Autowired
    AddressService addressService;
    @Autowired
    AddressMapper addressMapper;
    @PostMapping
    public ResponseEntity<?> add(@RequestBody AddressDto addressDto) {
        Address address= addressMapper.AddressDtoToAddress(addressDto);
        return new ResponseEntity<>(addressService.add(address), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Address address,@PathVariable("id") Long id) {
        return new ResponseEntity<>(addressService.update(address,id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAll(@RequestParam(defaultValue = "0") Integer pageNo,
                                    @RequestParam(defaultValue = "10") Integer pageSize,
                                    @RequestParam(defaultValue = "id") String sortBy) {
        return new ResponseEntity<>(addressService.getAll(pageNo,pageSize,sortBy), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Long id) {
        return new ResponseEntity<>(addressService.get(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        addressService.delete(id);
        return new ResponseEntity<>("address deleted", HttpStatus.OK);
    }

}
