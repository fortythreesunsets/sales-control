package com.proyecto1.springboot.jpa.app;
  
import java.util.Locale;

import org.springframework.context.annotation.Bean;

//import java.nio.file.Paths;
  
//import org.slf4j.Logger; 
//import org.slf4j.LoggerFactory; 
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
  
@Configuration 
public class MvcConfig implements WebMvcConfigurer {
	/*
	private final Logger log = LoggerFactory.getLogger(getClass());
  
	//addResourceHandlers sirve para agregar recursos estáticos al proyecto
  
	@Override 
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		WebMvcConfigurer.super.addResourceHandlers(registry); String resourcePath = Paths.get("uploads").toAbsolutePath().toUri().toString();
		//Debug del resourcePath log.info(resourcePath);
		registry.addResourceHandler("/uploads/**").addResourceLocations(resourcePath); 
		} */
	
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/error_403").setViewName("error_403");
	}
	
	@Bean 
	public static BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	//Establecer que el parámetro de idioma se guarde en la sesión
	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		localeResolver.setDefaultLocale(new Locale("es", "ES"));	//Establecer idioma por defecto
		return localeResolver;
	}
	
	//Interceptor para cambiar Locale cada vez que se escoja otro idioma
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor localeInterceptor = new LocaleChangeInterceptor();
		localeInterceptor.setParamName("lang");
		return localeInterceptor;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
	}
	
	@Bean
	public Jaxb2Marshaller jaxb2Marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setClassesToBeBound(new Class[] {com.proyecto1.springboot.jpa.app.view.xml.ClienteList.class});
		return marshaller;
	}
}
 