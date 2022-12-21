package in.selfproject.expensetrackerapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import in.selfproject.expensetrackerapi.cors.configuration.CORSConfiguration;

@SpringBootApplication
public class ExpensetrackerapiApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ExpensetrackerapiApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(ExpensetrackerapiApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean<CORSConfiguration> corsFilterRegistration() {
		FilterRegistrationBean<CORSConfiguration> registrationBean = new FilterRegistrationBean<CORSConfiguration>(
				new CORSConfiguration());
		registrationBean.setName("CORS Filter");
		registrationBean.addUrlPatterns("*");
		registrationBean.setOrder(1);
		return registrationBean;
	}

}
