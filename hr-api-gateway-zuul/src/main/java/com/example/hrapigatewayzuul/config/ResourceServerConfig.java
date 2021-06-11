package com.example.hrapigatewayzuul.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
	
	private static final List<String> CORS_ALLOWED_METHODS = Arrays.asList(
			HttpMethod.POST.name(), HttpMethod.GET.name(), HttpMethod.DELETE.name(), 
			HttpMethod.PUT.name(), HttpMethod.PATCH.name());
	
	private static final List<String> CORS_ALLOWED_HEADERS = Arrays.asList(
			HttpHeaders.AUTHORIZATION, HttpHeaders.CONTENT_TYPE);

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
		
		http.cors().configurationSource(corsConfigurationSource());
	}

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration corsConfig = new CorsConfiguration();
		corsConfig.setAllowedOrigins(Arrays.asList("*"));
		corsConfig.setAllowedMethods(CORS_ALLOWED_METHODS);
		corsConfig.setAllowCredentials(true);
		corsConfig.setAllowedHeaders(CORS_ALLOWED_HEADERS);
		
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", corsConfig);
		
		return source;
	}
	
	@Bean
	public FilterRegistrationBean<CorsFilter> corsFilter() {
		FilterRegistrationBean<CorsFilter> filterBean = 
				new FilterRegistrationBean<>(new CorsFilter(corsConfigurationSource()));
		filterBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		
		return filterBean;
	}
	
}
