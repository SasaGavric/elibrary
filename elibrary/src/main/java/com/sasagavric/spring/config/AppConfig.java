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
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.format.FormatterRegistry;
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
import com.sasagavric.spring.formatter.BookFormatter;
import com.sasagavric.spring.formatter.MemberFormatter;


/**
 * @author Sasa Gavric
 *
 */
@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy
@EnableTransactionManagement
@ComponentScan("com.sasagavric.spring")
@PropertySources({
	@PropertySource("classpath:persistence-mysql.properties"),
	@PropertySource("classpath:mail.properties")
})
public class AppConfig implements WebMvcConfigurer {
	
	@Autowired
	private Environment env;
	
	@Autowired
	private MemberFormatter memberFormatter;
	
	@Autowired
	private BookFormatter bookFormatter;
	
	
	/**
	 * define a bean for view resolver
	 * @return 
	 */
	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
	/**
	 * define bean for DataSource (database connection configuration)
	 * @return 
	 */
	@Bean
	public DataSource myDataSource() {
		
		
		// create connection pool
		ComboPooledDataSource myDataSource = new ComboPooledDataSource();

		// set the jdbc driver
		try {
			myDataSource.setDriverClass(env.getProperty("jdbc.driver"));		
		}
		catch (PropertyVetoException exc) {
			throw new RuntimeException(exc);
		}
		
		// set database connection props
		myDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		myDataSource.setUser(env.getProperty("jdbc.user"));
		myDataSource.setPassword(env.getProperty("jdbc.password"));
		
		// set connection pool props
		myDataSource.setInitialPoolSize(convertEnv("connection.pool.initialPoolSize"));
		myDataSource.setMinPoolSize(convertEnv("connection.pool.minPoolSize"));
		myDataSource.setMaxPoolSize(convertEnv("connection.pool.maxPoolSize"));		
		myDataSource.setMaxIdleTime(convertEnv("connection.pool.maxIdleTime"));
		

		return myDataSource;
	}
	
	/**
	 * set sql dialect and show hibernate transactions
	 * @return 
	 */
	private Properties getHibernateProperties() {

		// set hibernate properties
		Properties props = new Properties();

		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		props.setProperty("hibernate.show_sql", "true");
		props.setProperty("spring.jpa.properties.javax.persistence.validation.mode", "none");
		
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
	 * @return 
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
	 * 
	 * @return
	 */
	@Bean("messageSource")
	public ResourceBundleMessageSource customMessages() {
		
		ResourceBundleMessageSource messagesResource = new ResourceBundleMessageSource();
		
		messagesResource.addBasenames("resources/messages");
		
		return messagesResource;
		
	}
	
	
	/**
	 * enable support for sending mail
	 * @return 
	 */
	@Bean
	public JavaMailSenderImpl javaMailSenderimpl() {
		
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		
		Properties javaMailProp = new Properties();
		javaMailProp.setProperty("mail.transport.protocol", "smtp");
		javaMailProp.setProperty("mail.smtp.auth", "true");
		javaMailProp.setProperty("mail.smtp.starttls.enable", "true");
		javaMailProp.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");
		
		mailSender.setHost(env.getProperty("mail.host"));
		mailSender.setPort(convertEnv("mail.port"));
		mailSender.setUsername(env.getProperty("mail.username"));
		mailSender.setPassword(env.getProperty("mail.password"));
		mailSender.setJavaMailProperties(javaMailProp);
		
		return mailSender;
	}

	/* Add Formatters (convert String id to object)
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurer#addFormatters(org.springframework.format.FormatterRegistry)
	 */
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addFormatter(memberFormatter);
		registry.addFormatter(bookFormatter);		
	}

	/**
	 * From String property name get int property value
	 * @param propName
	 * @return
	 */
	private int convertEnv(String propName) {
		
		String property = env.getProperty(propName);
		
		int convProp = Integer.parseInt(property);
				
		return convProp;		
		
	}
	

}
