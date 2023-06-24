package com.example.demo.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by M.Hadiyan
 * Date: 6/24/2023
 * Time: 10:07 AM
 **/
@Entity
@Table
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String userName;


    @Column
    private String password;


    @OneToMany(mappedBy = "users",fetch = FetchType.LAZY)
    private List<Roles> roles;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Roles> getRoles() {
        return roles;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }
}
