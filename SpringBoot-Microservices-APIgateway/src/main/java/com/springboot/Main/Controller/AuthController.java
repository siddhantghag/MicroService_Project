package com.springboot.Main.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.Main.Model.AuthResponces;



/*notes =
 * 
1) @RegisteredOAuth2AuthorizedClient -:This annotation may be used to resolve a method parameter to an argument value of type OAuth2AuthorizedClient.

2) OAuth2AuthorizedClient -: i)A representation of an OAuth 2.0 "Authorized Client".
                             ii)A client is considered "authorized" when the End-User (Resource Owner) has granted authorization to the client to access it's protected resources.
                             iii)This class associates the Client to the Access Token granted/authorized by the Resource Owner.

3) @AuthenticationPrincipal -: Annotation that is used to resolve Authentication.getPrincipal() to a method argument.

4) OidcUser -: Implementation instances of this interface represent an AuthenticatedPrincipalwhich is associated to an 
               Authentication object and may be accessed via Authentication.getPrincipal().
               
5) Model -: i) Interface that defines a holder for model attributes. 
            ii) Primarily designed for adding attributes to the model. 

*/


@RestController
@RequestMapping("/auth")
public class AuthController 
{
	private Logger logger =LoggerFactory.getLogger(AuthController.class);
	
	@GetMapping("/login")
	public ResponseEntity<AuthResponces> login (
			@RegisteredOAuth2AuthorizedClient("okta") OAuth2AuthorizedClient auth2AuthorizedClient ,
			@AuthenticationPrincipal OidcUser oidcUser ,
			Model model )
	{
		logger.info("user email id : {}" ,oidcUser.getEmail());
		
		//Creating authResponces object create
		AuthResponces authResponces= new AuthResponces();
		
		//set email to aurhResponces
		authResponces.setUserId(oidcUser.getEmail());
		
		//set token to authResonces
		authResponces.setAccessToken(auth2AuthorizedClient.getAccessToken().getTokenValue());
		
		authResponces.setRefreshToken(auth2AuthorizedClient.getRefreshToken().getTokenValue());
		
		authResponces.setExpireAt(auth2AuthorizedClient.getAccessToken().getExpiresAt().getEpochSecond());
		
		
		//create the collection - Convert to the getAuthorities() to collection<String>.
		List<String> authorities = oidcUser.getAuthorities().stream().map(GrantedAuthority -> {
			return GrantedAuthority.getAuthority();	
		}).collect(Collectors.toList());
		
		authResponces.setAuthorities(authorities);
		
		return  new ResponseEntity<AuthResponces>(authResponces,HttpStatus.OK);
    }	
}

