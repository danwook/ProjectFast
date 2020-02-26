package com.example.study.repository;

import com.example.study.model.entity.User;
import org.graalvm.compiler.nodes.calc.IntegerDivRemNode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    //쿼리메소드

//    //계정으로
//    Optional<User> findByAccount(String account);
//
//    //메일로
//    Optional<User> findByEmail(String email);
//
//    //동시에
//    Optional<User> findByAccountAndEmail(String account, String email);

    //핸드폰으로 검색하게끔 - FirstBy : 한건에 대해서 가장 최근것이 리턴됨
    User findFirstByPhoneNumberOrderByIdDesc(String phoneNumber);

}
