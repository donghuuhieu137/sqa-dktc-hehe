package com.hieudh.dktc.entity;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "tbl_user")
@Data
public class User {

    @Id
    @SequenceGenerator(name = "id_seq", sequenceName = "item_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "ho_va_ten")
    @NotNull
    private String hoVaTen;

    @Column(name = "password")
    @NotNull
    private String password;

    @Column(name = "phone")
    @NotNull
    private String phone;

    @Column(name = "email")
    @NotNull
    private String email;

    @Column(name = "ma_sinh_vien")
    @NotNull
    private String maSinhVien;
    @Column(name = "khoa")
    @NotNull
    private int khoa;

    @ManyToMany()
    @JoinTable(
            name = "users_subjects",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private Set<Subject> subjects;

    public User() {
    }

    public User(Long id, String username, @NotNull String hoVaTen, @NotNull String password, @NotNull String phone, @NotNull String email, @NotNull String maSinhVien, @NotNull int khoa) {
        this.id = id;
        this.username = username;
        this.hoVaTen = hoVaTen;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.maSinhVien = maSinhVien;
        this.khoa = khoa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @NotNull
    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(@NotNull String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    @NotNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NotNull String password) {
        this.password = password;
    }

    @NotNull
    public String getPhone() {
        return phone;
    }

    public void setPhone(@NotNull String phone) {
        this.phone = phone;
    }

    @NotNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NotNull String email) {
        this.email = email;
    }

    @NotNull
    public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(@NotNull String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    @NotNull
    public int getKhoa() {
        return khoa;
    }

    public void setKhoa(@NotNull int khoa) {
        this.khoa = khoa;
    }
}
