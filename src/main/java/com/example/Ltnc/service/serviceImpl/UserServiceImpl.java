package com.example.Ltnc.service.serviceImpl;


import com.example.Ltnc.model.domain.Privilege;
import com.example.Ltnc.model.domain.Role;
import com.example.Ltnc.model.domain.User;
import com.example.Ltnc.model.repository.PrivilegeRepostory;
import com.example.Ltnc.model.repository.RoleRepostory;
import com.example.Ltnc.model.repository.UserRepostory;
import com.example.Ltnc.service.UserService;
import com.example.Ltnc.service.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepostory UserRepo;
    @Autowired
    private RoleRepostory RoleRepo;
    @Autowired
    private PrivilegeRepostory privilegeRepo;

    private PasswordEncoder encoder() {
        return  new BCryptPasswordEncoder();
    }
    @Override
    public User saveUser(UserDto userDto) {
        Privilege privilege = privilegeRepo.findByName("USER_READ");
        Privilege privilege1 = privilegeRepo.findByName("USER_SIGNIN");
        Collection<String> roleDto = userDto.getRole();
        Collection<Role>  listRole = new ArrayList<>();
        roleDto.forEach(ro -> {
            switch (ro) {
                case "user": {
                    Role userRole = RoleRepo.findByName("USER");
                    if (userRole == null) {
                        userRole = new Role("USER");
                        RoleRepo.save(userRole);
                    }
                    listRole.add(userRole);
                    break;
                }
                case "manager" :{
                    Role managerRole = RoleRepo.findByName("MANAGER");
                    if (managerRole == null) {
                        managerRole = new Role("MANAGER");
                        RoleRepo.save(managerRole);
                    }
                    listRole.add(managerRole);
                    break;
                }
                case "admin" :{
                    Role managerRole = RoleRepo.findByName("ADMIN");
                    if (managerRole == null) {
                        managerRole = new Role("ADMIN");
                        RoleRepo.save(managerRole);
                    }
                    listRole.add(managerRole);
                    break;
                }
            }
        });

        User user =User.builder()
                .userName(userDto.getUsername())
                .passWord(encoder().encode(userDto.getPassword()))
                .email(userDto.getEmail())
                .roles(listRole)
                .build();
        Collection<Role> roles = user.getRoles();
        Collection<Privilege> privileges = new ArrayList<>();
        privileges.add(privilege);
        privileges.add(privilege1);
        roles.forEach(role -> {
            role.setPrivileges(privileges);
        });

        return UserRepo.save(user);
    }

    @Override
    public List<User> getAllUser() {
        List<User> users = UserRepo.findAll();
        return users;
    }

    @Override
    public void deleteUser(int id) {
        UserRepo.deleteById(id);
    }

    @Override
    public Page<User> findByUserNameContaining(String name, Pageable pageable) {
        return UserRepo.findByUserNameContaining(name, pageable);
    }

    @Override
    public void deleteRoleId(Integer id, String name) {
        RoleRepo.deleteRoleId(id, name);
    }

    @Override
    public User getUserByName(String username) {
        return UserRepo.getUserByName(username);
    }
}