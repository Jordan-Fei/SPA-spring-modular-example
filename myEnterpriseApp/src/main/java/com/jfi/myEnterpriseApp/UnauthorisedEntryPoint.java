package com.jfi.myEnterpriseApp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.stereotype.Component;

/**
 * Just return 401-unauthorized for every unauthorized request. The client side
 * catches this and handles login itself.
 */
@Component(value = "unauthorisedEntryPoint")
public class UnauthorisedEntryPoint implements AuthenticationEntryPoint {
	
	private static final Logger logger = LoggerFactory.getLogger(UnauthorisedEntryPoint.class);

	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
		String path = request.getRequestURI().substring(request.getContextPath().length());
		logger.info("Request path is {}.", path);
		
		if(path.indexOf("/login") >= 0 || path.indexOf("/authenticate") >= 0){
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
		}
		else{
			HttpSession session =  request.getSession();
			
			RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
			redirectStrategy.sendRedirect(request, response, "/login");
			
			//Store the "path" in session
			
			if(session!=null){
				session.setAttribute("OriginalPath", path);
			}
		}
	}

}