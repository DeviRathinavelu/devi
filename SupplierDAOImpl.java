package com.devi.bags.dao;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.devi.bags.model.Product;


@Repository
public class SupplierDAOImpl implements SupplierDAO {
	@Autowired
	private Supplier supplier;
	@Autowired
	private SessionFactory sessionFactory;

	public boolean save(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().save(supplier);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public boolean update(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().update(supplier);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public boolean delete(String id) {
		try {
			sessionFactory.getCurrentSession().delete(supplier);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public Supplier get(String id) {
		String hql = "from Supplier where id='" + id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Supplier> list =(List<Supplier>)query;
		if (list != null || list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	public List<Supplier> list() {
		return null;
	}

	public boolean create(Supplier supplier) {
		// TODO Auto-generated method stub
		return false;
	}

	public SupplierDAO get(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
