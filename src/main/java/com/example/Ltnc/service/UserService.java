package com.example.Ltnc.service;

import com.example.Ltnc.model.domain.User;
import com.example.Ltnc.service.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public User saveUser(UserDto userDto);
    public List<User> getAllUser();
    public void deleteUser(int id);

    Page<User> findByUserNameContaining(String name, Pageable pageable);

    void deleteRoleId(Integer id, String name);

    User getUserByName(String username);
}