package com.java.application.controller;

import com.java.application.dao.UsersDao;
import com.java.application.dto.EntityNotFoundResponse;
import com.java.application.exception.EntityNotFoundException;
import com.java.application.model.Users;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    private final UsersDao usersDao;

    public UsersController(UsersDao usersDao) {
        this.usersDao = usersDao;
    }


    @GetMapping
    public List<Users> getAll(){
        return usersDao.findAll();
    }

    @GetMapping("/number")
    public List<Users> getAllNumber(){
        return usersDao.findAllNumber();
    }

    @GetMapping("/{id}")
    public Users getUsers(@PathVariable Long id){
        checkById(id);
        return usersDao.findById(id).orElse(null);
    }


    @PostMapping("/save")
    public Users addUsers(@RequestBody Users users){
        System.out.println(users);
        return usersDao.save(users);
    }

    @PutMapping("/{productId}")
    public Users updateUsers(@RequestBody Users users, @PathVariable(name = "usersId") Long id){
        users.setId(id);
        System.out.println(users);
        return usersDao.save(users);
    }

    @DeleteMapping("/{id}")
    public void deleteUsers(@PathVariable Long id){
        checkById(id);
        usersDao.deleteById(id);
    }

    //проверка id
    private void checkById(@PathVariable Long id) {
        if(!usersDao.existsById(id)){
            throw new EntityNotFoundException("Product", id, "Product not found");
        }
    }

    @ExceptionHandler// будут обрабатываься ошибки
    public ResponseEntity<EntityNotFoundResponse> handleException(EntityNotFoundException ex){//ResponseEntity обертка по статусам
        EntityNotFoundResponse response = new EntityNotFoundResponse();
        response.setEntityName(ex.getEntityName());
        response.setEntityId(ex.getEntityId());
        response.setMessage(ex.getMessage());
        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }


}
