package com.java.application.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "phoneBook")
public class PhoneBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToMany
    @JoinTable(
            name = "phoneBook_users",
            joinColumns = @JoinColumn(name = "phoneBook_id"),
            inverseJoinColumns = @JoinColumn(name = "users_id")
    )
    private List<Users> users;

    public PhoneBook() {
    }

    public PhoneBook(Long id, List<Users> users) {
        this.id = id;
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }
}
