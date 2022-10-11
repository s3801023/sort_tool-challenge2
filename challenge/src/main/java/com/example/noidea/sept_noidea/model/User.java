package com.example.noidea.sept_noidea.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "persons")
@EntityListeners(AuditingEntityListener.class)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "UID", nullable = false)
    private int userid;
    private String username;
    private String password;
    private int age;
    private String email;
    private String mobile;

    @Column(name = "DF", nullable = false)
    private int deleteFlag;

    public User() {
    }

    public User(int userid,String username, String password, int age, String email, String mobile, int deleteFlag) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.email = email;
        this.mobile = mobile;
        this.deleteFlag = deleteFlag;
        this.age = age;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername(){return username;}
    public void setUsername(String username){this.username = username;}
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge(){return age;}
    public void setAge(int age){this.age = age;}
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(int deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", deleteFlag=" + deleteFlag +
                '}';
    }
}