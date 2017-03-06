package com.example.configure.models;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by rewat on 11/30/16.
 */
@Entity
@Table(name = "users")
public class User {
    //The entity fields (private)

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String email;

    @NotNull
    private String name;

    //public methods
    public User(){}

    public User(Long id){
        this.id = id;
    }

    public User(String email, String name){
        this.email = email;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
