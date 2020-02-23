package com.example.study.repository;


import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class UserRepositoryTest extends StudyApplicationTests {
    //Dependency Injection (DI)
    @Autowired //직접객체를 만들지않고 스프링이 객체를 관리하고 직접 주입하겠다는거임
    private UserRepository userRepository;

    //CRUD 테스트
    @Test
    public void create() {
        User user = new User();
        user.setAccount("TestUser01");
        user.setEmail("TestUser01@gmail.com");
        user.setPhoneNumber("010-1111-1111");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("TestUser2");

        User newUser = userRepository.save(user);
        System.out.println("newUser : "+newUser);

    }

    public void read(){

    }

    public void update(){

    }

    public void delete(){

    }
}
