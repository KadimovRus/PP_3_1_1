package com.example.pp_3_1_1.model;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "age")
    private Byte age;

}
