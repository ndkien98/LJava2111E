package com.t3h.demospringsecurity.service.security;

import com.t3h.demospringsecurity.model.entity.RoleEntity;
import com.t3h.demospringsecurity.model.entity.UserEntity;
import com.t3h.demospringsecurity.repository.IRoleRepository;
import com.t3h.demospringsecurity.repository.IUserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserDetailServiceImpl implements UserDetailsService {

    private final IUserRepository userRepository;
    private final IRoleRepository roleRepository;

    public UserDetailServiceImpl(IUserRepository userRepository, IRoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity userEntity = userRepository.findByUsername(username);

        if (userEntity == null){
            System.out.println("User not found");
            throw new UsernameNotFoundException("User not found");
        }

        List<RoleEntity> roleEntities = roleRepository.getByUserId(userEntity.getId());
        List<String> roleNameOfUser = roleEntities.stream().map(RoleEntity::getRoleName).collect(Collectors.toList());

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        roleNameOfUser.stream().forEach(roleName -> {
            GrantedAuthority authority = new SimpleGrantedAuthority(roleName);
            grantedAuthorities.add(authority);
        });

        UserDetails userDetails = new User(userEntity.getUsername(),userEntity.getEncryptedPassword(),grantedAuthorities);
        return userDetails;
    }
}
