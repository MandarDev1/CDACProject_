package com.mandardev.blog.security;

public class JwtAuthenticationEntryPoint AuthenticationEntryPoint {
	
	 @Override
	    public void commence(HttpServletRequest request, HttpServletResponse response,
	                         AuthenticationException authException) throws IOException, ServletException {
	        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Access Denied !!");
	    }

}
