package com.gl.config;
import java.util.Properties;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

@EnableWebMvc
@Configuration
@ComponentScan("com.gl")
public class AppConfig implements WebMvcConfigurer{

	@Autowired
	ApplicationContext applicationContext;

	@Bean
	public ViewResolver thymeleafResolver() {
		ThymeleafViewResolver ivr = new ThymeleafViewResolver();
		ivr.setTemplateEngine(templateEngine());
		ivr.setOrder(0);
		return ivr;
	}

	@Bean
	public SpringResourceTemplateResolver templateResolver() {
		SpringResourceTemplateResolver srtr = new SpringResourceTemplateResolver();
		srtr.setApplicationContext(applicationContext);
		srtr.setPrefix("/WEB-INF/views/");
		srtr.setSuffix(".html");
		return srtr;
	}

	@Bean
	public SpringTemplateEngine templateEngine() {
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver());
		templateEngine.setEnableSpringELCompiler(true);
		return templateEngine;
	}
	 @Bean
	    public BasicDataSource dataSource() {
	        BasicDataSource dataSource = new BasicDataSource();
	
	        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
	        dataSource.setUrl("jdbc:mysql://localhost:3306/springhibernateproject");
	        dataSource.setUsername("root");
	        dataSource.setPassword("9kkk");

	        return dataSource;
	    }
	
	  private final Properties hibernateProperties() {
	        Properties hibernateProperties = new Properties();
	
	        hibernateProperties.setProperty(
	          "hibernate.hbm2ddl.auto", "update");
	
	        hibernateProperties.setProperty(
	          "hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");

	        return hibernateProperties;
	    }
	
	@Bean
 public LocalSessionFactoryBean sessionFactory() {
     LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
     sessionFactory.setDataSource(dataSource());

     sessionFactory.setPackagesToScan(new String[] { "com.gl.model"});
     
     sessionFactory.setHibernateProperties(hibernateProperties());

     return sessionFactory;
 }



 @Bean
 public PlatformTransactionManager hibernateTransactionManager() {
     HibernateTransactionManager transactionManager
       = new HibernateTransactionManager();
     transactionManager.setSessionFactory(sessionFactory().getObject());
     return transactionManager;
 }

}

