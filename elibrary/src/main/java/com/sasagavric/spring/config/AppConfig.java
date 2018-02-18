package com.sasagavric.spring.config;

import java.beans.PropertyVetoException;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @author Sasa
 *
 */
@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy
@EnableTransactionManagement
@ComponentScan("com.sasagavric.spring")
public class AppConfig implements WebMvcConfigurer {
	
	/**
	 * define a bean for view resolver
	 * @return ViewResolver
	 */
	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
	/**
	 * define bean for DataSource (database xonnection configuration)
	 * @return DataSource
	 */
	@Bean
	public DataSource myDataSource() {
		
		// create connection pool
		ComboPooledDataSource myDataSource = new ComboPooledDataSource();

		// set the jdbc driver
		try {
			myDataSource.setDriverClass("com.mysql.jdbc.Driver");		
		}
		catch (PropertyVetoException exc) {
			throw new RuntimeException(exc);
		}
		
		// set database connection props
		myDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/elibrary?useSSL=false");
		myDataSource.setUser("library_administrator");
		myDataSource.setPassword("library");
		
		// set connection pool props
		myDataSource.setInitialPoolSize(5);
		myDataSource.setMinPoolSize(5);
		myDataSource.setMaxPoolSize(20);		
		myDataSource.setMaxIdleTime(30000);

		return myDataSource;
	}
	
	/**
	 * set sql dialect and show hibernate transactions
	 * @return Properties
	 */
	private Properties getHibernateProperties() {

		// set hibernate properties
		Properties props = new Properties();

		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		props.setProperty("hibernate.show_sql", "true");
		
		return props;				
	}
	
	/**
	 * define bean fo SessionFactory (Hibernate)
	 * @return
	 */
	@Bean
	public LocalSessionFactoryBean sessionFactory(){
		
		// create session factorys
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		
		// set the properties
		sessionFactory.setDataSource(myDataSource());
		sessionFactory.setPackagesToScan("com.sasagavric.entity");
		sessionFactory.setHibernateProperties(getHibernateProperties());
		
		return sessionFactory;
	}
	
	/**
	 * define bean for transaction management
	 * @param sessionFactory
	 * @return HibernateTransactionManager
	 */
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		
		// setup transaction manager based on session factory
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);

		return txManager;
	}	
	
	
	/*
	 * provide support for static resources like html,css,images and js
	 *  (non-Javadoc)
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurer#addResourceHandlers(org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry)
	 */
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
          .addResourceHandler("/resources/**")
          .addResourceLocations("/resources/"); 
    }

	@Override
	public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.configureHandlerExceptionResolvers(resolvers);
	}	
	
	
	/**
	 * enable support for sending mail
	 * @return JavaMailSenderImpl
	 */
	@Bean
	public JavaMailSenderImpl javaMailSenderimpl() {
		
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		
		Properties javaMailProp = new Properties();
		javaMailProp.setProperty("mail.transport.protocol", "smtp");
		javaMailProp.setProperty("mail.smtp.auth", "true");
		javaMailProp.setProperty("mail.smtp.starttls.enable", "true");
		javaMailProp.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");
		
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);
		mailSender.setUsername("springmvcsendexceptionmail@gmail.com");
		mailSender.setPassword("sasa12345");
		mailSender.setJavaMailProperties(javaMailProp);
		
		return mailSender;
	}
	
	

}
