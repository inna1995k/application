package com.java.application.dao;

import com.java.application.model.PhoneBook;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PhoneBookDao extends JpaRepository<PhoneBook, Long> {
}
