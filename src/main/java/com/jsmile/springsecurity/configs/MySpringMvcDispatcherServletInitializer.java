package com.jsmile.springsecurity.configs;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 *  Instead of web.xml : 'dispatcher'
 * */
public class MySpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{

	@Override
	protected Class<?>[] getRootConfigClasses()
	{
		// TODO Auto-generated method stub
		return null;
	}

	// Instead of init-param : 'contextConfigLocation'
	@Override
	protected Class<?>[] getServletConfigClasses()
	{
		return new Class[] { AppConfig.class };
	}

	// instead of sverlet mapping : dispatcher
	@Override
	protected String[] getServletMappings()
	{
		return new String[] { "/" };
	}

}
