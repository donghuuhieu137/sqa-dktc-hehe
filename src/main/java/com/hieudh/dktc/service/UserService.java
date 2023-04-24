package com.hieudh.dktc.service;

import com.hieudh.dktc.dto.UserDTO;
import com.hieudh.dktc.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public interface UserService {
    public UserDTO getCurrentUser(Long id);

    public User getUserByName(String name);

    public User findById(Long id);


    @Transactional
    abstract void save(User user);

    public long login(String username, String password);
}
