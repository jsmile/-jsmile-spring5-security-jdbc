package com.jsmile.springsecurity.configs;


import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;



@Configuration
@EnableWebMvc
@ComponentScan( basePackages="com.jsmile.springsecurity" )
@PropertySource( "classpath:jdbc-mariaDB.properties" )
public class AppConfig
{
	// set up variable to hold the properties
	@Autowired
	private Environment env;
	
	// set up logger
	Logger logger = Logger.getLogger( getClass().getName() ); 
			
	
	// define a bean for ViewResolver
	@Bean
	public ViewResolver viewResolver() 
	{
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix( "/WEB-INF/views/" );
		viewResolver.setSuffix( ".jsp" );
		
		return viewResolver;
	}
	
	// define a bean for security dataSource
	@Bean
	public DataSource securityDataSource() 
	{
		// create connection pool
		ComboPooledDataSource securityDataSource = new ComboPooledDataSource();
		
		try 
		{
			// set the jdbc driver class and the database connection props
			securityDataSource.setDriverClass( env.getProperty( "jdbc.driver" ) );
			securityDataSource.setJdbcUrl( env.getProperty( "jdbc.url" ) );
			securityDataSource.setUser( env.getProperty( "jdbc.user" ) );
			securityDataSource.setPassword( env.getProperty( "jdbc.password" ) );

			// log the connection	props
			logger.info( "\n>>> jdbc.url : " + env.getProperty( "jdbc.driver" ) );
			logger.info( ">>> jdbc.user : " + env.getProperty( "jdbc.user" ) );
			
			// set connection pool props
			securityDataSource.setInitialPoolSize( getIntProperty( "connection.pool.initialPoolSize" ) );
			securityDataSource.setMinPoolSize( getIntProperty( "connection.pool.minPoolSize" ) );
			securityDataSource.setMaxPoolSize( getIntProperty( "connection.pool.maxPoolSize" ) );
			securityDataSource.setMaxIdleTime( getIntProperty( "connection.pool.maxIdleTime" ) );
			
		} 
		catch ( PropertyVetoException e ) 
		{
			throw new RuntimeException( e );
		}
		
		return securityDataSource;
	}
	
	// create a helper method 
	// : read environment property and convert to int
	private int getIntProperty(String _propName ) 
	{
		String propVal = env.getProperty( _propName );
		
		// now convert to int
		int intPropVal = Integer.parseInt( propVal );
		
		return intPropVal;
	}

}
