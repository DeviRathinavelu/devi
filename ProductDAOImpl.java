package com.devi.bags.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.devi.bags.model.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {
@Autowired
private Product product;
@Autowired
private SessionFactory sessionFactory;
public ProductDAOImpl(SessionFactory sessionfactory)
{
	this.sessionFactory=sessionfactory;
}
@Transactional
public boolean save(Product product) {
	try {
		sessionFactory.getCurrentSession().save(product);
	} catch (Exception e) {
		e.printStackTrace();
		return false;// TODO Auto-generated method stub
	}
	return true;
}
@Transactional
public boolean update(Product product) {
	try {
		sessionFactory.getCurrentSession().update(product);
	} catch (Exception e) {
		e.printStackTrace();
		return false;
}// TODO Auto-generated method stub
	return true;
}
@Transactional
public void delete(String id) {
	Product ProductToDelete = new Product();
	ProductToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(ProductToDelete);
}
@Transactional
public ProductDAO get(String id) {
	String hql = "from Product where id='" + id + "'";
	Query query = sessionFactory.getCurrentSession().createQuery(hql);
	List<Product> list =(List<Product>)query;
	if (list != null || list.isEmpty()) // TODO Auto-generated method stub
	return null;
	return (ProductDAO) list.get(0);
}
@Transactional
public List<ProductDAO> list() {
	// TODO Auto-generated method stub
	return null;
}

}