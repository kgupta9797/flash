package com.kishan.spring_boot.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class Config extends WebSecurityConfigurerAdapter {

	

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("Admin")
		.password("Admin")
		.roles("admin_role")
		.and()
		.withUser("kishan")
		.password("guddu")
		.roles("student_role");
		// TODO Auto-generated method stub
		//super.configure(auth);
	}

//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		
//		
//		
//		super.configure(web);
//	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.
			httpBasic()
			.and()
			.authorizeRequests()
			.antMatchers("/delete_Admin").hasRole("admin_role") //Only admin can delete the 
		//	.antMatchers("/create_stud").hasRole("admin_role") //Admin can also create the studnt
			.antMatchers("/create_stud").hasRole("student_role") //only Student can create request
//			.and()
//			.authorizeRequests()
			
			.and()
			.authorizeRequests()
			//.antMatchers("/create_stud").hasRole("student_role") //only Student can create request
			.and()
			
			.formLogin();
		
		super.configure(http);
	}
	
	@Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
	
}
