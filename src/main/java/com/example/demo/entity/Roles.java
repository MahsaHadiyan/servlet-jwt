package com.example.demo.entity;

import javax.persistence.*;

/**
 * Created by M.Hadiyan
 * Date: 6/24/2023
 * Time: 10:10 AM
 **/
@Entity
@Table
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String userName;


    @Column
    private String roleName;

    @ManyToOne(cascade = CascadeType.ALL)
    private Users users;

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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
