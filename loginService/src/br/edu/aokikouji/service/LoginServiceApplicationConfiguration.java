package br.edu.aokikouji.service;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/")
public class LoginServiceApplicationConfiguration extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> loginServiceResource = new HashSet<>();
		loginServiceResource.add(LoginService.class);
		return loginServiceResource;
	}
	
}
