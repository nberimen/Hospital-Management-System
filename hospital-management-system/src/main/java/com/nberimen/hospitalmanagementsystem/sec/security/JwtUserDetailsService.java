package com.nberimen.hospitalmanagementsystem.sec.security;

import com.nberimen.hospitalmanagementsystem.user.User;
import com.nberimen.hospitalmanagementsystem.user.entityservice.UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {

    private final UserEntityService userEntityService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Long identityNo = Long.valueOf(username);
        User inDB = userEntityService.findByIdentityNo(identityNo);
        if (inDB == null) {
            throw new UsernameNotFoundException("User not found!");
        }
        return JwtUserDetails.createAuth(inDB);
    }

    public UserDetails loadUserByUserName(Long id) {
        User inDB = userEntityService.findByIdentityNo(id);
        if (inDB == null) {
            throw new UsernameNotFoundException("User not found!");
        }
        return JwtUserDetails.createAuth(inDB);
    }
}
