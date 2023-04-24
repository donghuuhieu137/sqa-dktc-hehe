package com.hieudh.dktc.dto;

import com.hieudh.dktc.common.Expense;
import com.hieudh.dktc.entity.User;

public class UserDTO extends AbstractDTO<UserDTO> {

    private String username;
    private String hoVaTen;
    private String phone;
    private String email;
    private String password;

    public UserDTO(User user) {
        super();
        if (user != null) {
            this.setId(user.getId());
            this.username = user.getUsername();
            this.hoVaTen = user.getHoVaTen();
            this.phone = user.getPhone();
            this.email = user.getEmail();
        }
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}