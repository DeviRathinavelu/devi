package com.devi.bags.dao;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.devi.bags.model.Product;


@Repository
public class ProductDAOImpl implements ProductDAO {
	@Autowired
	private Product product;
	@Autowired
	private SessionFactory sessionFactory;

	public boolean save(Product product) {
		try {
			sessionFactory.getCurrentSession().save(product);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public boolean update(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public boolean delete(String id) {
		try {
			sessionFactory.getCurrentSession().delete(product);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public Product get(String id) {
		String hql = "from Product where id='" + id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Product> list =(List<Product>)query;
		if (list != null || list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	public List<Product> list() {
		return null;
	}

	public boolean create(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	public ProductDAO get(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
