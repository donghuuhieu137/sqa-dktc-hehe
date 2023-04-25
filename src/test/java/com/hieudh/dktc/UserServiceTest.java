package com.hieudh.dktc;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.NoSuchElementException;
import java.util.Optional;

import com.hieudh.dktc.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.hieudh.dktc.dto.UserDTO;
import com.hieudh.dktc.entity.User;
import com.hieudh.dktc.repository.UserRepository;

public class UserServiceTest {

    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        userService = new UserServiceImpl(userRepository);
    }

    @Test
    public void testGetCurrentUser() {
        Long userId = 1L;
        User user = new User();
        user.setId(userId);
        user.setHoVaTen("cao thanh huy");
        user.setKhoa(19);
        user.setMaSinhVien("B19DCCN303");
        user.setPhone("019232131");
        user.setEmail("huy@gmail.com");
        user.setUsername("testuser");
        user.setPassword("testpassword");

        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        UserDTO result = userService.getCurrentUser(userId);

        assertEquals(user.getUsername(), result.getUsername());
        assertEquals(user.getId(), result.getId());
    }

    @Test
    public void testSave() {
        User user = new User();
        user.setUsername("testuser");
        user.setPassword("testpassword");

        userService.save(user);

        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void testLogin() {
        String username = "testuser";
        String password = "testpassword";
        Long userId = 1L;
        User user = new User();
        user.setId(userId);
        user.setHoVaTen("cao thanh huy");
        user.setKhoa(19);
        user.setMaSinhVien("B19DCCN303");
        user.setPhone("019232131");
        user.setEmail("huy@gmail.com");
        user.setUsername(username);
        user.setPassword(password);

        when(userRepository.findOneByUsername(username)).thenReturn(user);

        long result = userService.login(username, password);

        assertEquals(userId.longValue(), result);
    }

    @Test
    public void testGetUserByName() {
        String username = "testuser";
        User user = new User();
        user.setUsername(username);
        user.setId(1L);
        user.setHoVaTen("cao thanh huy");
        user.setKhoa(19);
        user.setMaSinhVien("B19DCCN303");
        user.setPhone("019232131");
        user.setEmail("huy@gmail.com");
        user.setUsername(username);
        user.setPassword("password");

        when(userRepository.findOneByUsername(username)).thenReturn(user);

        User result = userService.getUserByName(username);

        assertEquals(user, result);
    }

    @Test
    public void testFindById() {
        Long userId = 1L;
        User user = new User();
        user.setId(userId);

        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        User result = userService.findById(userId);

        assertEquals(user, result);
    }

}