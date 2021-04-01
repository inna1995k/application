package com.java.application.mapper;

import com.java.application.dto.UserDto;
import com.java.application.model.Users;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


import java.util.List;

@Mapper
public interface UsersMapper {
    UsersMapper MAPPER = Mappers.getMapper(UsersMapper.class);

    Users toUsers(UserDto dto);

    @InheritInverseConfiguration
    UserDto fromUsers(Users users);

    List<Users> toUsersList(List<UserDto> userDtos);

    List<UserDto> fromUsersList(List<Users> users);

}
