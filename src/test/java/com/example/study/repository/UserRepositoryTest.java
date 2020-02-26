package com.example.study.repository;


import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Item;
import com.example.study.model.entity.User;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

public class UserRepositoryTest extends StudyApplicationTests {
    //Dependency Injection (DI)
    @Autowired //직접객체를 만들지않고 스프링이 객체를 관리하고 직접 주입하겠다는거임
    private UserRepository userRepository;

    //CRUD 테스트
    @Test
    public void create() {
        User user = new User();
        user.setAccount("TestUser03");
        user.setEmail("TestUser03@gmail.com");
        user.setPhoneNumber("010-2221-1111");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("TestUser3");

        User newUser = userRepository.save(user);
        System.out.println("newUser : "+newUser);
    }

    @Test
    @Transactional
    public void read(){

         //select * from user where id =?
        //쿼리메소드
        Optional<User> user = userRepository.findByAccount("TestUser03");
        user.ifPresent(selectUser -> {
            selectUser.getOrderDetailList().stream().forEach(orderDetail -> {
                Item item = orderDetail.getItem();
                System.out.println(item); //객체반환
            });
        });
    }

    @Test
    public void update(){
        Optional<User> user = userRepository.findById(2L);

        user.ifPresent(selectUser->{
            selectUser.setAccount("PPPP");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("update method()");

            userRepository.save(selectUser);
        });

    }

    @Test
    @Transactional
    public void delete(){
        Optional<User> user = userRepository.findById(3L);

        Assert.assertTrue(user.isPresent()); //반드시 true여야함.

        user.ifPresent(selectUser->{
            userRepository.delete(selectUser);
        });

        Optional<User> deleteUser = userRepository.findById(3L);

        Assert.assertFalse(deleteUser.isPresent()); // 반드시 false여야함

    }
}
