package com.mandardev.blog.security;

import org.springframework.web.filter.OncePerRequestFilter;

public class JwtAuthenticationFilter extends OncePerRequestFilter  {
	
	@Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtHelper jwtTokenHelper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
        // Get token from request header
        String requestToken = request.getHeader("Authorization");

        if (requestToken != null && requestToken.startsWith("Bearer ")) {
            String token = requestToken.substring(7);
            String username = null;

            try {
                username = jwtTokenHelper.getUsernameFromToken(token);
            } catch (IllegalArgumentException e) {
                System.out.println("Unable to get Jwt token: " + e.getMessage());
            } catch (ExpiredJwtException e) {
                System.out.println("Jwt token has expired: " + e.getMessage());
            } catch (MalformedJwtException e) {
                System.out.println("Invalid jwt: " + e.getMessage());
            }

            // Validate the token
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);

                if (jwtTokenHelper.validateToken(token, userDetails)) {
                    UsernamePasswordAuthenticationToken authenticationToken =
                            new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                } else {
                    System.out.println("Invalid jwt token");
                }
            }
        } else {
            System.out.println("Jwt token does not begin with Bearer");
        }

        filterChain.doFilter(request, response);
    }

}
