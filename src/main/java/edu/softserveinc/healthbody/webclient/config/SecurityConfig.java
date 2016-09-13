package edu.softserveinc.healthbody.webclient.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
@ComponentScan(basePackages = "edu.softserveinc.healthbody.webclient")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	CustomAuthenticationProvider authProvider;
	//UserDetailService userDetailService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authProvider);
		//auth.userDetailsService(userDetailService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/login*", "/", "/homePage.html", "/resources/**","/GoogleAuthServ*")
				.permitAll().anyRequest().authenticated().and().formLogin().loginPage("/login.html")
				.defaultSuccessUrl("/main.html").failureUrl("/login.html?error=true").and().logout()
				.logoutSuccessUrl("/login.html");
	}
}