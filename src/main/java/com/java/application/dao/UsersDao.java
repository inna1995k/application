package com.java.application.dao;


import com.java.application.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsersDao extends JpaRepository<Users, Long> {
//    List<Users>  findByNumber(Long number);

    @Query(value = "SELECT number FROM users", nativeQuery = true)
    List<Users> findAllNumber();

}
