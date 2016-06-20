package com.ideaincubator.sprinkler.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CrossDomainFilter implements Filter{
//	@Inject
//    private SessionManager sessionManager;
//	
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
	}
	
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
	            throws ServletException, IOException {
	        if (request.getHeader("Access-Control-Request-Method") != null ) {
	            // CORS "pre-flight" request
	            response.addHeader("Access-Control-Allow-Origin", "http://192.173.7.33:8080");
	            response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
	            response.addHeader("Access-Control-Allow-Headers", "origin, content-type, accept, x-requested-with, sid, mycustom, smuser");
	            response.addHeader("Access-Control-Max-Age", "1800");//30 min
	        }
	        filterChain.doFilter(request, response);
	    }

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	

	
}

