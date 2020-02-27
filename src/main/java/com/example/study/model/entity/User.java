package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import java.time.LocalDateTime;
import java.util.List;
import com.example.study.model.entity.OrderGroup;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString(exclude = {"orderGroup"})
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String account;

    private String password;

    private String status;

    private String email;

    private String phoneNumber;

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;

    // User 1 : OrderGroup N
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<OrderGroup> orderGroupList;
    //원투매니여서 받아오는걸 list로 해줘야함.

}
