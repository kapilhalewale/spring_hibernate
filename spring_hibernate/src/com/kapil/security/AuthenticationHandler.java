package com.kapil.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationHandler extends SimpleUrlAuthenticationSuccessHandler
{
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException 
	{
		String targetUrl = determineTargetUrl(authentication);
		redirectStrategy.sendRedirect(request, response, targetUrl);
	}
	 
	protected String determineTargetUrl(Authentication authentication) 
	{
		String redirectURL = "";
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		List<String> roles = new ArrayList<String>();
		for (GrantedAuthority grantedAuthority : authorities) 
		{
			roles.add(grantedAuthority.getAuthority());
			if(grantedAuthority.getAuthority().equals("ROLE_ADMIN")) 
			{
				redirectURL = "/user/users";	            	
			} 
			else if(grantedAuthority.getAuthority().equals("ROLE_EMP")) 
			{
				redirectURL = "/employee/employees";	            	
			} 
		}
		return redirectURL;
	}		
}