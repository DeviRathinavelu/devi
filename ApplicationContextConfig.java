package com.devi.bags.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.devi.bags.dao.CategoryDAO;
import com.devi.bags.dao.SupplierDAO;
import com.devi.bags.dao.ProductDAO;
import com.devi.bags.dao.CategoryDAOImpl;
import com.devi.bags.dao.SupplierDAOImpl;
import com.devi.bags.dao.ProductDAOImpl;
import com.devi.bags.model.Category;
import com.devi.bags.model.Supplier;
import com.devi.bags.model.Product;

@Configuration
@ComponentScan("com")
@EnableTransactionManagement
public class ApplicationContextConfig {
	@Bean(name = "dataSource")
    public DataSource getDataSource() {
    	BasicDataSource dataSource = new BasicDataSource();
    	dataSource.setDriverClassName("org.h2.Driver");
    	dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
    	dataSource.setUsername("sa");
    	dataSource.setPassword("");
    	
    	return dataSource;
    }
    
    
    private Properties getHibernateProperties() {
    	Properties properties = new Properties();
    	properties.setProperty("hibernate.hbm2ddl.auto","update");
    	properties.put("hibernate.show_sql", "true");
    	properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
    	return properties;
    }
    
    @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) {
    	LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
    	sessionBuilder.addProperties(getHibernateProperties());
    	//sessionBuilder.addAnnotatedClasses(User.class);
    	sessionBuilder.addAnnotatedClasses(Category.class);
    	sessionBuilder.addAnnotatedClasses(Supplier.class);
    	sessionBuilder.addAnnotatedClasses(Product.class);
        	return sessionBuilder.buildSessionFactory();
    }
    
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(
			SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(
				sessionFactory);

		return transactionManager;
	}
	@Autowired
	@Bean(name="categorydao")
	public CategoryDAO getCategorydao(SessionFactory sessionFactory) {
		return new CategoryDAOImpl(sessionFactory);
	}

	@Autowired
	@Bean(name = "supplierdao")
	public SupplierDAO getSupplierdao(SessionFactory sessionFactory) {
	return new SupplierDAOImpl(sessionFactory);
	}
	@Autowired
	@Bean(name = "productdao")
	public ProductDAO getProductdao(SessionFactory sessionFactory) {
	return new ProductDAOImpl(sessionFactory);
	}

 }





