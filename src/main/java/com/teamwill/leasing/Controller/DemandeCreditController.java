package com.teamwill.leasing.Controller;


import com.teamwill.leasing.Dto.DemandeCreditDto;
import com.teamwill.leasing.Entity.DemandeDeCredit;
import com.teamwill.leasing.Entity.Product;
import com.teamwill.leasing.Mapper.DemandeCreditMapper;
import com.teamwill.leasing.Service.DemandeDeCreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/simulations")
public class DemandeCreditController {
    @Autowired
    DemandeDeCreditService demandeDeCreditService;
    @Autowired
    DemandeCreditMapper demandeCreditMapper;


    @PostMapping
    public DemandeDeCredit add(@RequestBody DemandeCreditDto demandeCreditDto){
        DemandeDeCredit demandeCredit=demandeCreditMapper.DemandeDeCreditDtoToDemandeDeCredit(demandeCreditDto);
        return  demandeDeCreditService.add(demandeCredit);

    }
    @GetMapping()
    public ResponseEntity<?> getAll(@RequestParam(defaultValue = "0") Integer pageNo,
                                    @RequestParam(defaultValue = "10") Integer pageSize,
                                    @RequestParam(defaultValue = "id") String sortBy) {
        return new ResponseEntity<>(demandeDeCreditService.getAll(pageNo,pageSize,sortBy), HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody DemandeCreditDto demandeCreditDto, @PathVariable("id") Long id) {
        DemandeDeCredit demandeCredit=demandeCreditMapper.DemandeDeCreditDtoToDemandeDeCredit(demandeCreditDto);
        return new ResponseEntity<>(demandeDeCreditService.update(demandeCredit,id), HttpStatus.OK);
    }



    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Long id) {
        return new ResponseEntity<>(demandeDeCreditService.get(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        demandeDeCreditService.delete(id);
        return new ResponseEntity<>( HttpStatus.OK);

    }
    @GetMapping("/get-total")
    public ResponseEntity<?> getTotal() {
        return new ResponseEntity<>(demandeDeCreditService.getTotal(), HttpStatus.OK);
    }
}
