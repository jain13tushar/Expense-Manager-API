package in.selfproject.expensetrackerapi.cors.configuration;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.GenericFilterBean;

public class CORSConfiguration extends GenericFilterBean implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
		httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
		httpServletResponse.setHeader("Access-Control-Allow-Headers", "*");
		httpServletResponse.setHeader("Access-Control-Allow-Credentials", "false");
		httpServletResponse.setHeader("Access-Control-Max-Age", "3600");
		chain.doFilter(request, response);
	}

}
