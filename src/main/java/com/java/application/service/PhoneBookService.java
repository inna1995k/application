package com.java.application.service;

import com.java.application.dto.PhoneBookDto;
import com.java.application.model.Users;

import java.util.List;

public interface PhoneBookService {

    PhoneBookDto findById(Long id);

    List<PhoneBookDto> findAll();

    PhoneBookDto save(PhoneBookDto dto);

}
