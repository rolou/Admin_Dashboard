package com.rvalencia.admindashboard.services;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Service;

import com.rvalencia.admindashboard.models.Role;
import com.rvalencia.admindashboard.repositories.UserRepo;
import com.rvalencia.admindashboard.models.User;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService {

private UserRepo userRepo;
    
    public UserDetailsServiceImplementation(UserRepo userRepo){
        this.userRepo = userRepo;
    }
    // 1
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        
        if(user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthorities(user));
    }
    
    // 2
    private List<GrantedAuthority> getAuthorities(User user){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for(Role role : user.getRoles()) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getName());
            authorities.add(grantedAuthority);
        }
        return authorities;
    }
}
