package com.hieudh.dktc.service.impl;

import com.hieudh.dktc.dto.UserDTO;
import com.hieudh.dktc.entity.User;
import com.hieudh.dktc.repository.UserRepository;
import com.hieudh.dktc.service.UserService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @PersistenceContext protected EntityManager entityManager;
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository injectedBean) {
        this.userRepository = injectedBean;
    }

    @Override
    public UserDTO getCurrentUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        UserDTO dto = new UserDTO(user.get());
        return dto;
    }

    @Override
    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public long login(String username, String password) {
        User user = userRepository.findOneByUsername(username);
        if(user.getId() != null){
            if(Objects.equals(password, user.getPassword())){
                return user.getId();
            }
        }
        return -1;
    }

	@Override
	public User getUserByName(String name) {
		User user = userRepository.findOneByUsername(name);
        if(user.getId() != null){
            return user;
        }
        return null;
	}

    @Override
    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }
}
