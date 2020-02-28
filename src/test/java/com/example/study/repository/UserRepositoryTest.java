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
        String account = "Test03";
        String password = "Test03";
        String status =  "REGISTERED";
        String email = "Test01@gmail.com";
        String phoneNumber = "010-3333-2222";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";


        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setStatus(status);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setRegisteredAt(registeredAt);

        User u =  User.builder()
                .account(account)
                .password(password)
                .status(status)
                .email(email)
                .build();


        User newUser = userRepository.save(user);
        Assert.assertNotNull(newUser);
        Assert.assertEquals(newUser.getAccount(),account);
        Assert.assertEquals(newUser.getPassword(),password);
    }

    @Test
    @Transactional
    public void read(){

        //select * from user where id =?
        //쿼리메소드
//        Optional<User> user = userRepository.findByAccount("TestUser03");
//        user.ifPresent(selectUser -> {
//            selectUser.getOrderDetailList().stream().forEach(orderDetail -> {
//                Item item = orderDetail.getItem();
//                System.out.println(item); //객체반환
//            });
//        });
        User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1111-2222");
        if(user!=null){

            user.getOrderGroupList().stream().forEach(orderGroup -> {

                System.out.println("=======주문묶음=========");
                System.out.println(orderGroup.getRevName());
                System.out.println(orderGroup.getTotalPrice());
                System.out.println(orderGroup.getTotalQuantity());
                System.out.println(orderGroup.getRevAddress());

                System.out.println("=======주문상세=========");
                orderGroup.getOrderDetailList().forEach(orderDetail -> {
                    System.out.println("파트너사 이름 : "+orderDetail.getItem().getPartner().getName());
                    System.out.println("파트너사 카테고리 :"+orderDetail.getItem().getPartner().getCategory().getTitle());
                    System.out.println("주문상품 : "+orderDetail.getItem().getName());
                    System.out.println("고객센터번호 :"+orderDetail.getItem().getPartner().getCallCenter());
                    System.out.println(orderDetail.getStatus());
                    System.out.println(orderDetail.getArrivalDate());


                });
            });

            Assert.assertNotNull(user);
        }


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
