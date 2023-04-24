package com.hieudh.dktc.dto;

import com.hieudh.dktc.entity.User;

public class RegisterDTO extends AbstractDTO<RegisterDTO> {

    private String username;
    private String hoVaTen;
    private String password;
    private int khoa;

    private String maSinhVien;
    private String phone;
    private String email;

    public RegisterDTO() {
        super();
    }

    public RegisterDTO(User user) {
        super();
        this.setId(user.getId());
        this.username = user.getUsername();
        this.hoVaTen = user.getHoVaTen();
        this.phone = user.getPhone();
        this.email = user.getEmail();
        this.khoa = user.getKhoa();
        this.maSinhVien = user.getMaSinhVien();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getKhoa() {
        return khoa;
    }

    public void setKhoa(int khoa) {
        this.khoa = khoa;
    }

    public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }
}