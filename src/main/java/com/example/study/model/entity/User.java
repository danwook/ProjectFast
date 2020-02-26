package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String account;

    private String email;

    private String phoneNumber;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;

    //유저는 1이지만 orderdetail은 N이다
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user") // 여기서 매핑되는 이름은 userDetail에 선언해놓은거랑 동일해야함
    private List<OrderDetail> orderDetailList;
}
