package com.anhnbt.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configurable
public class SecurityConfiguration {

	@Autowired
	UserDetailsServiceImpl userDetailsServiceImpl;

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(authorize -> authorize
					.mvcMatchers("/", "/login", "/signup", "/about").permitAll()
					.mvcMatchers("/admin/**").hasRole("ADMIN")
					.mvcMatchers("/home", "/manage-students").authenticated()
					.anyRequest().denyAll()
				)
				.csrf((csrf) -> csrf.disable())
				.formLogin(form -> {
					try {
						form
								.loginPage("/login")
								.defaultSuccessUrl("/home")
								.usernameParameter("username")
								.passwordParameter("password")
								.and().exceptionHandling().accessDeniedPage("/access-denied")
								.and()
								.logout().logoutUrl("/logout").logoutSuccessUrl("/login");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});
		return http.build();
	}

	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
