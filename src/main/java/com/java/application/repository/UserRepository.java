package com.java.application.repository;

import com.java.application.dto.UserDto;
import com.java.application.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
//    Users findByNumber(Integer number);
    List<Users> findAllByNumber(Long number);
//    List<Users> findByNumber(Users users);
}
