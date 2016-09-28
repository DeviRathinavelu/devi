package com.devi.bags.config;

import java.util.Properties;
import javax.activation.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.devi.bags.dao.CategoryImpl;
import com.devi.bags.model.category;
import com.devi.bags.model.user;
@Configuration
@ComponentScan("com.devi.bags")
@EnableTransactionManagement
public class ApplicationContextConfig{
	@Bean(name= "H2dataSource")
	public DriverManagerDataSource getH2DataSource()
	{
	DriverManagerDataSource	dataSource=new DriverManagerDataSource();
	String url="jdbc:h2:mem:test;"+"INIT=CREATE SCHEMA IF NOT EXISTS TEST";
	dataSource.setDriverClassName("org.h2.Driver");
	dataSource.setUrl(url);
	dataSource.setUsername("sa");
	dataSource.setPassword(null);
	return  dataSource;
	}
	@Bean(name="dataSource")
	public DataSource getMySQLDataSource()
	{
		BasicDataSource dataSource=new BasicDataSource();
		dataSource.setDriverClassName("niit.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/niitdb");
		dataSource.setUsername("sa");
		dataSource.setPassword(" ");
		return (DataSource) dataSource;
	}
private Properties getHibernateProperties(){
	Properties properties=new Properties();
	properties.setProperty("hibernate.hbm2ddl.auto","update");
	properties.put("hibernate.show_sql", "true");
	properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
	return properties;
}
@Autowired
@Bean(name="sessionFactory")
public SessionFactory getSessionFactory(DataSource dataSource)
{
 LocalSessionFactoryBuilder sessionBuilder=new LocalSessionFactoryBuilder((javax.sql.DataSource) dataSource);
 sessionBuilder.addProperties(getHibernateProperties());
 sessionBuilder.addAnnotatedClasses(user.class);
	sessionBuilder.addAnnotatedClasses(Category.class);
	sessionBuilder.addAnnotatedClasses(Supplier.class);
	sessionBuilder.addAnnotatedClasses(Product.class);
	sessionBuilder.addAnnotatedClasses(Userdetails.class);
 	return sessionBuilder.buildSessionFactory();
}
@Autowired
@Bean(name="transactionManager")
public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
{
	HibernateTransactionManager transactionManager=new HibernateTransactionManager(sessionFactory);
	return transactionManager;
}
@Autowired
@Bean(name="categorydao")
	public Category getCategorydao(SessionFactory sessionFactory)
	{
		return new CategoryImpl(sessionFactory);
	}
		 

@Autowired
@Bean(name="cartDao")
	public CartDao getCartDao(SessionFactory sessionFactory)
	{
		return new CategoryImpldao(sessionFactory);
	}
}


