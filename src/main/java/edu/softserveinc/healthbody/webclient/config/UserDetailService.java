package edu.softserveinc.healthbody.webclient.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.softserveinc.healthbody.webclient.healthbody.webservice.HealthBodyServiceImplService;
import edu.softserveinc.healthbody.webclient.healthbody.webservice.UserDTO;

@Service
public class UserDetailService implements UserDetailsService{
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		UserDTO userDTO = new HealthBodyServiceImplService().getHealthBodyServiceImplPort().getUserByLogin(userName);
		 List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	        if (userDTO.getRoleName().equals("admin")) {
	            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
	        }
	        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		UserDetails user = new User(userDTO.getLogin(), userDTO.getPassword(), authorities);
		return user;
	}

}
