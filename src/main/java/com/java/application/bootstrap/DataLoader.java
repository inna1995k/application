package com.java.application.bootstrap;

import com.java.application.dao.PhoneBookDao;
import com.java.application.dao.UsersDao;
import com.java.application.model.PhoneBook;
import com.java.application.model.Users;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    private final PhoneBookDao phoneBookDao;
    private final UsersDao usersDao;

    public DataLoader(PhoneBookDao phoneBookDao, UsersDao usersDao) {
        this.phoneBookDao = phoneBookDao;
        this.usersDao = usersDao;
    }

    @Override
    public void run(String... args) throws Exception {
        initData();
    }

    private void initData(){

        Users anna = new Users(1L,"Anna", 89231343454L);
        Users alex = new Users(2L,"Alex", 89213421243L);

        System.out.println("init Products");
        anna = usersDao.save(anna);
        alex = usersDao.save(alex);


        System.out.println("init orders");
        PhoneBook phoneBook1 = new PhoneBook();
        phoneBook1.setUsers(new ArrayList<>(Arrays.asList(anna, alex)));
        phoneBookDao.save(phoneBook1);

//        Order order2 = new Order();
//        order2.setProducts(new ArrayList<>(Arrays.asList(cheese, beer)));
//        orderDao.save(order2);
//
//        Order order3 = new Order();
//        order3.setProducts(new ArrayList<>(Arrays.asList(cheese, bread)));
//        orderDao.save(order3);

    }

}
