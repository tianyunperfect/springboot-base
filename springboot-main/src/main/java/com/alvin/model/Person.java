package com.alvin.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity(name = "person")
public class Person {
    /**
     * 主键id
     * 主键自增 @GeneratedValue(strategy = GenerationType.IDENTITY)
     * 主键不自增 @GeneratedValue
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * name
     */
    @Column(name = "name", length = 20)
    private String name;

    @Column(name = "age", nullable = false, length = 2)
    private int age;

    @Column(nullable = false, unique = true)
    private String email;

    @Column
    private Date createTime;
}
