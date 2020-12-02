package com.example.demo.authFilter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.demo.AuthService.MyUserDetailsService;
import com.example.demo.configSecurite.useToken;

import net.bytebuddy.asm.MemberSubstitution.Substitution.Chain;

@Component
public class jwtFitler extends OncePerRequestFilter {
	@Autowired
	private useToken ut;
	@Autowired
	private MyUserDetailsService MyUserDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		String header = request.getHeader("Authorization");
		String token = null;
		String username = null;
		if (header != null && header.startsWith("Bearer ")) {
			token = header.substring(7);
			username = ut.getUsernameFromToken(token);
		}
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userdetails = MyUserDetailsService.loadUserByUsername(username);
			if (ut.validateToken(token, userdetails)) {
				UsernamePasswordAuthenticationToken Authentication = new UsernamePasswordAuthenticationToken(
						userdetails.getUsername(), userdetails.getPassword());
				Authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(Authentication);

			}

		}
		filterChain.doFilter(request, response);

	}

}
