package com.java.application.service;

import com.java.application.dao.PhoneBookDao;
import com.java.application.dto.PhoneBookDto;
import com.java.application.mapper.PhoneBookMapper;
import com.java.application.model.PhoneBook;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneBookServiceImpl implements PhoneBookService {

    private final PhoneBookMapper mapper = PhoneBookMapper.MAPPER;

    private final PhoneBookDao dao;

    public PhoneBookServiceImpl(PhoneBookDao dao) {
        this.dao = dao;
    }

    @Override
    public PhoneBookDto findById(Long id) {
        return mapper.fromPhoneBook(dao.getOne(id));
    }

    @Override
    public List<PhoneBookDto> findAll() {
        return mapper.fromPhoneBookList(dao.findAll());
    }

    @Override
    public PhoneBookDto save(PhoneBookDto dto) {
        PhoneBook entity = mapper.toPhoneBook(dto);
        PhoneBook savedEntity = dao.save(entity);
        return mapper.fromPhoneBook(savedEntity);
    }

}
