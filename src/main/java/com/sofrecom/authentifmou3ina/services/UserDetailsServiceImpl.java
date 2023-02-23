package com.sofrecom.authentifmou3ina.services;

import com.sofrecom.authentifmou3ina.entities.Mou3inaEntity;
import com.sofrecom.authentifmou3ina.repository.Mou3inaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
@Autowired
Mou3inaRepository userRepository;
@Override
@Transactional
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
Mou3inaEntity mou3inaEntity = userRepository.findByUsername(username)
.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
return UserDetailsImpl.build(mou3inaEntity);
}
}