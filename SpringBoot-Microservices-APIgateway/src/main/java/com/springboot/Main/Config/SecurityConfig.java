package com.springboot.Main.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;


/* Notes :
	This project we can use the API gateway , Now we can use the web flux .
	  -@EnableWebFluxSecurity
	  -ServerHttpSecurity
	  
	  Then we can use normal Security So Use the :
	  -@EnableWebSecurity
	  -HttpSecurity
	 */

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig 
{
	@Bean 
	public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity serverHttpSecurity )
	{
		serverHttpSecurity
			.authorizeExchange()
			.anyExchange()
			.authenticated()
			.and()
			.oauth2Client()
			.and()
			.oauth2ResourceServer()
			.jwt();
		//.oauth2Client() - This line we can use login customize 
		//.oauth2ResourceServer() - This we can use the oauth server configure.
		return serverHttpSecurity.build(); 
	}
}
