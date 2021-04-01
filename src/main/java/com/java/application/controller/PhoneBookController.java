package com.java.application.controller;

import com.java.application.dto.PhoneBookDto;
import com.java.application.service.PhoneBookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phoneBooks")
public class PhoneBookController {

    private final PhoneBookService phoneBookService;
//    private final PhoneBookDao phoneBookDao;

    public PhoneBookController(PhoneBookService phoneBookService) {
        this.phoneBookService = phoneBookService;
    }

    @GetMapping("/{id}")
    public PhoneBookDto getPhoneBook(@PathVariable Long id){
        return phoneBookService.findById(id);
    }

    @GetMapping("/list")
    public List<PhoneBookDto> list(){
        return phoneBookService.findAll();
    }

    @PostMapping("/save")
    public PhoneBookDto save(@RequestBody PhoneBookDto dto){
        return phoneBookService.save(dto);
    }

}
