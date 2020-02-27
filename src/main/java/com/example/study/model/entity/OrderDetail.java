package com.example.study.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString(exclude = {"orderGroup","item"})
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    private LocalDateTime arrivalDate;

    private Integer quantity;

    private BigDecimal totalPrice;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;

    // OrderDetail N : Item 1 : 아이템마다 여러주문건이 있을수 있기 때문.
    @ManyToOne(fetch =  FetchType.LAZY)
    private Item item;

    //OrderDetail N, OrderGroup는 1임
    @ManyToOne(fetch = FetchType.LAZY)
    private OrderGroup orderGroup; //연결되고자 하는 mappedBy에 변수명과 같아야함.


//    // N이고 유저는 1 자신은 여러개지만 유저는 1개다.
//    @ManyToOne
//    private User user; // user_id.
//
//    // 자신은 1, 아이템은 N이다
//
//    @ManyToOne
//    private Item item;

}
