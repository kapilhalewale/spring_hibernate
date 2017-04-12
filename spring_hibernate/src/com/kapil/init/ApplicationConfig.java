package com.kapil.init;
/*
 *  Author : Kapil Kumar;
 * This class is a replacement of spring-dispatcher-servlet.xml file
 */
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.kapil.dao.EmployeeDao;
import com.kapil.dao.EmployeeDaoImpl;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = "com.kapil")
public class ApplicationConfig  extends WebMvcConfigurerAdapter
{
	   @Autowired
	   private Environment env;
	   
		@Bean
		public ViewResolver viewResolver() {
			InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
			viewResolver.setViewClass(JstlView.class);
			viewResolver.setPrefix("/WEB-INF/views/");
			viewResolver.setSuffix(".jsp");
			return viewResolver;
		}


	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer)
	{
		configurer.enable();
	}
	
	  @Bean
	   public LocalSessionFactoryBean sessionFactory()
	  {
	      LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	      sessionFactory.setDataSource(kapDataSource());
	      sessionFactory.setPackagesToScan(new String[] { "com.kapil.domain" });
	      sessionFactory.setHibernateProperties(hibernateProperties());
	      return sessionFactory;
	   }
	 
	   @Bean
	   public DataSource kapDataSource()
	   {
	      BasicDataSource dataSource = new BasicDataSource();
	      dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	      dataSource.setUrl("jdbc:mysql://localhost:3306/employee");
	      dataSource.setUsername("root");
	      dataSource.setPassword("database");
	      return dataSource;
	   }
	 
	   @Bean
	   @Autowired
	   public HibernateTransactionManager transactionManager(SessionFactory sessionFactory)
	   {
	      HibernateTransactionManager txManager  = new HibernateTransactionManager();
	      txManager.setSessionFactory(sessionFactory);
	      return txManager;
	   }
	 
	   @Bean
	   public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
	      return new PersistenceExceptionTranslationPostProcessor();
	   }
	 
	   Properties hibernateProperties()
	   {
	      return new Properties() {
	         {
	            setProperty("hibernate.hbm2ddl.auto", "update");
	            setProperty("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
	            setProperty("hibernate.globally_quoted_identifiers","true");
	         }
	      };
	   }
	   
	   @Autowired
	   @Bean(name = "employeeDao")
	   public EmployeeDao  getEmployeeDao(SessionFactory sessionFactory) {
	       return new EmployeeDaoImpl();
	   }
}
