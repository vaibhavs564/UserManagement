package com.practice.UserManagement.dao;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class User {
     @Id
     @Column
     @GeneratedValue(strategy = GenerationType.AUTO)
     public Long id;
     @Column
     public String name;
     @Column
     public String email;
     @Column
     public String mobile;
     @Column
     public String address;
}
