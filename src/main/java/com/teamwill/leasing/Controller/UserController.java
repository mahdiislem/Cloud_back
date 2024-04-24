package com.teamwill.leasing.Controller;

import com.teamwill.leasing.Config.Search.SearchOperation;
import com.teamwill.leasing.Config.Search.UserSpecificationsBuilder;
import com.teamwill.leasing.Dto.DemandeCreditDto;
import com.teamwill.leasing.Dto.UserDto;
import com.teamwill.leasing.Entity.DemandeDeCredit;
import com.teamwill.leasing.Entity.User;
import com.teamwill.leasing.Mapper.UserMapper;
import com.teamwill.leasing.Service.AccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.google.common.base.Joiner;

import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private UserMapper modelMapper;

    @PostMapping
    public User add(@RequestBody UserDto userDto){
        User user=modelMapper.UserDtoToUser(userDto);
        return  accountService.add(user);
    }
    @GetMapping()
    public ResponseEntity<?> getAll(@RequestParam(defaultValue = "0") Integer pageNo,
                                    @RequestParam(defaultValue = "10") Integer pageSize,
                                    @RequestParam(defaultValue = "id") String sortBy) {
        return new ResponseEntity<>(accountService.getAll(pageNo,pageSize,sortBy), HttpStatus.OK);

    }
/*
    @GetMapping
    public ResponseEntity<?> getAll(@RequestParam(defaultValue = "0") Integer pageNo,
                                    @RequestParam(defaultValue = "10") Integer pageSize,
                                    @RequestParam(defaultValue = "id") String sortBy,
                                    @RequestParam(value = "search") String search) {
        search=search.replaceAll("%20","");
        System.out.println(search);
        UserSpecificationsBuilder builder = new UserSpecificationsBuilder();
        String operationSetExper = Joiner.on("|").join(SearchOperation.SIMPLE_OPERATION_SET);
        //Pattern pattern = Pattern.compile("(\\p{Punct}?)(\\w+?)(" + operationSetExper + ")(\\p{Punct}?)(\\w+?)(\\p{Punct}?),");
        Pattern pattern = Pattern.compile(
                "(\\w+?)(" + operationSetExper +")(\\p{Punct}?)(\\w+?)(\\p{Punct}?),");
        Matcher matcher = pattern.matcher(search + ",");
        while (matcher.find()) {
            builder.with(
                    matcher.group(1),
                    matcher.group(2),
                    matcher.group(4),
                    matcher.group(3),
                    matcher.group(5));
        }
        Specification<User> spec = builder.build();
        return new ResponseEntity<>(accountService.getAll(pageNo,pageSize,sortBy,spec), HttpStatus.OK);
    }
*/
    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Long id) {
        return new ResponseEntity<>(accountService.get(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        accountService.delete(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> ipdate(@RequestBody UserDto userDto,@PathVariable("id") Long id) {
        User user=modelMapper.UserDtoToUser(userDto);
        return new ResponseEntity<>(accountService.update(user,id), HttpStatus.OK);
    }
    @GetMapping("/get-total")
    public ResponseEntity<?> getTotal() {
        return new ResponseEntity<>(accountService.getTotal(), HttpStatus.OK);
    }

}

