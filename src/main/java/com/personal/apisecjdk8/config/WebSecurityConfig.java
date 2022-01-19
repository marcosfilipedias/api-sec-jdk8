package com.personal.apisecjdk8.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import com.personal.apisecjdk8.jwt.JWTAuthorizationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
		
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable()
        .authorizeRequests()
        .antMatchers(
      		  "/**/public/**",
                "/v2/api-docs", 
                "/swagger-resources/**",  
                "/swagger-ui.html", 
                "/webjars/**" ,
                "/swagger.json").permitAll()
        .anyRequest().authenticated()
        .and()
        .addFilter(jwtBasicAuthenticationFilter())
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

	@Bean
	public JWTAuthorizationFilter jwtBasicAuthenticationFilter() throws Exception {
		return new JWTAuthorizationFilter(authenticationManager());
	}	
}
