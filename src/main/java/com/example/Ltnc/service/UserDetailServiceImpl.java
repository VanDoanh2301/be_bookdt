package com.example.Ltnc.service;


import com.example.Ltnc.model.domain.User;
import com.example.Ltnc.model.repository.UserRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

@Autowired
private UserRepostory repo;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
       User user = repo.getUserByName(userName);
        if(user == null) {
            throw  new UsernameNotFoundException("User not found");
        }

        //Logic to get the user form the Database
        return new UserDetailImpl(user);
    }
}
