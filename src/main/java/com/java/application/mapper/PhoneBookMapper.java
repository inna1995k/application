package com.java.application.mapper;


import com.java.application.dto.PhoneBookDto;
import com.java.application.dto.UserDto;
import com.java.application.model.PhoneBook;
import com.java.application.model.Users;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(uses = {UsersMapper.class})
public interface PhoneBookMapper {
    PhoneBookMapper MAPPER = Mappers.getMapper(PhoneBookMapper.class);

    @Mapping(source = "phoneBookUsers", target = "users")
    PhoneBook toPhoneBook(PhoneBookDto dto);

    List<PhoneBook> toPhoneBookList(List<PhoneBookDto> phoneBooks);

    @InheritInverseConfiguration
    PhoneBookDto fromPhoneBook(PhoneBook phoneBook);

    List<PhoneBookDto> fromPhoneBookList(List<PhoneBook> phoneBooks);

}
