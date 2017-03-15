//package by.boiko.snet.service.impl;
//
//
//import by.boiko.snet.model.UserRoleEnum;
//import by.boiko.snet.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.HashSet;
//
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    @Autowired
//    private UserService userService;
//
//    @Override
//    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
//        UserForTwitter userForTwitter = userService.findByLogin(login);
//        HashSet<SimpleGrantedAuthority> roles = new HashSet<>();
//        roles.add(new SimpleGrantedAuthority(UserRoleEnum.ROLE_USER.name()));
//        roles.add(new SimpleGrantedAuthority(UserRoleEnum.ROLE_ADMIN.name()));
//        roles.add(new SimpleGrantedAuthority(UserRoleEnum.ROLE_ANONYMOUS.name()));
//        return new org.springframework.security.core.userdetails.User(userForTwitter.getLogin(), userForTwitter.getPassword(), roles);
//    }
//}