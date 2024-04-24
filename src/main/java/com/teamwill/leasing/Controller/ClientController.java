package com.teamwill.leasing.Controller;
import com.teamwill.leasing.Dto.MoralClientDto;
import com.teamwill.leasing.Dto.PhysicalClientDto;
import com.teamwill.leasing.Dto.UserDto;
import com.teamwill.leasing.Entity.Client;
import com.teamwill.leasing.Entity.User;
import com.teamwill.leasing.Mapper.ClientMapper;
import com.teamwill.leasing.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/clients")

public class ClientController {
        @Autowired
        ClientService clientService;
        @Autowired
        ClientMapper clientMapper;


    @PostMapping
    public Client add(@RequestBody PhysicalClientDto physicalClientDto){
        Client client=clientMapper.PhysicalClientDtoToClient(physicalClientDto);
        return  clientService.add(client);

    }
    @GetMapping()
    public ResponseEntity<?> getAll(@RequestParam(defaultValue = "0") Integer pageNo,
                                    @RequestParam(defaultValue = "10") Integer pageSize,
                                    @RequestParam(defaultValue = "id") String sortBy) {
        return new ResponseEntity<>(clientService.getAll(pageNo,pageSize,sortBy), HttpStatus.OK);

    }

    @GetMapping("/byEmail")
    public ResponseEntity<?> getAll(@RequestParam String email) {
        return new ResponseEntity<>(clientService.getAllClientByEmail(email), HttpStatus.OK);

    }
        @PostMapping("/physical")
        public ResponseEntity<?> addPhysical(@RequestBody PhysicalClientDto physicalClientDto) {
            Client client=clientMapper.PhysicalClientDtoToClient(physicalClientDto);
            return new ResponseEntity<>(clientService.add(client), HttpStatus.OK);
        }
        @PostMapping("/moral")
        public ResponseEntity<?> addMoral(@RequestBody MoralClientDto moralClientDto) {
            Client client=clientMapper.MoralClientDtoToClient(moralClientDto);
            return new ResponseEntity<>(clientService.add(client), HttpStatus.OK);
        }


        @PutMapping("/{id}")
        public ResponseEntity<?> update(@RequestBody PhysicalClientDto physicalClientDto, @PathVariable("id") Long id) {
            Client client=clientMapper.PhysicalClientDtoToClient(physicalClientDto);
            return new ResponseEntity<>(clientService.add(client),HttpStatus.OK);
        }
        @GetMapping("/physical")
        public ResponseEntity<?> getAllPhysical(@RequestParam(defaultValue = "0") Integer pageNo,
                                    @RequestParam(defaultValue = "10") Integer pageSize,
                                    @RequestParam(defaultValue = "id") String sortBy) {
            return new ResponseEntity<>(clientService.getAllPhysicalClient(pageNo,pageSize,sortBy),HttpStatus.OK);
        }
        @GetMapping("/moral")
        public ResponseEntity<?> getAllMoral(@RequestParam(defaultValue = "0") Integer pageNo,
                                        @RequestParam(defaultValue = "10") Integer pageSize,
                                        @RequestParam(defaultValue = "id") String sortBy) {
            return new ResponseEntity<>(clientService.getAllMoralClient(pageNo,pageSize,sortBy),HttpStatus.OK);
        }

        @GetMapping("/{id}")
        public ResponseEntity<?> get(@PathVariable("id") Long id) {
            return new ResponseEntity<>(clientService.get(id), HttpStatus.OK);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<?> delete(@PathVariable("id") Long id) {
            clientService.delete(id);
            return new ResponseEntity<>("client deleted", HttpStatus.OK);
        }

    @GetMapping("/get-total")
    public ResponseEntity<?> getTotal() {
        return new ResponseEntity<>(clientService.getTotal(), HttpStatus.OK);
    }


}

