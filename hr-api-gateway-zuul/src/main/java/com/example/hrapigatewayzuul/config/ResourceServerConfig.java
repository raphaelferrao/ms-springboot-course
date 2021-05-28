package com.example.hrapigatewayzuul.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
	
	private static final String[] PUBLIC_URLS = { "/hr-oauth/oauth/token" };
	
	private static final String[] ROLE_OPERATOR_URLS = { "/hr-worker/**" };
	
	private static final String[] ROLE_ADMIN_URLS = { "/hr-payroll/**", "/hr-user/**", "/actuator/**",
			"/hr-worker/actuator/**", "/hr-oauth/actuator/**"};
	
	@Autowired
	private JwtTokenStore tokenStore;

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.tokenStore(tokenStore);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
			.antMatchers(PUBLIC_URLS).permitAll()
			.antMatchers(HttpMethod.GET, ROLE_OPERATOR_URLS).hasAnyRole("OPERATOR", "ADMIN")
			.antMatchers(ROLE_ADMIN_URLS).hasAnyRole("ADMIN")
			.anyRequest().authenticated();
	}

	
	
}
