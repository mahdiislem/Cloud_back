package com.teamwill.leasing.Controller;

import com.teamwill.leasing.Dto.FournisseurDto;
import com.teamwill.leasing.Entity.Fournisseur;
import com.teamwill.leasing.Mapper.FournisseurMapper;
import com.teamwill.leasing.Service.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fournisseurs")
public class FournisseurController {
    @Autowired
    FournisseurService fournisseurService;
    @Autowired
    FournisseurMapper fournisseurMapper;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody FournisseurDto fournisseurDto) {
        Fournisseur fournisseur=fournisseurMapper.FournisseurDtoToFournisseur(fournisseurDto);
        return new ResponseEntity<>(fournisseurService.add(fournisseur), HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody FournisseurDto fournisseurDto, @PathVariable("id") Long id) {
        Fournisseur fournisseur=fournisseurMapper.FournisseurDtoToFournisseur(fournisseurDto);
        return new ResponseEntity<>(fournisseurService.add(fournisseur),HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity<?> getAll(@RequestParam(defaultValue = "0") Integer pageNo,
                                    @RequestParam(defaultValue = "10") Integer pageSize,
                                    @RequestParam(defaultValue = "id") String sortBy) {
        return new ResponseEntity<>(fournisseurService.getAll(pageNo,pageSize,sortBy),HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Long id) {
        return new ResponseEntity<>(fournisseurService.get(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        fournisseurService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/get-total")
    public ResponseEntity<?> getTotal() {

        return new ResponseEntity<>(fournisseurService.getTotal(), HttpStatus.OK);

    }
}
