package com.devi.bags.dao;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.devi.bags.model.Supplier;


@Repository
public class SupplierDAOImpl implements SupplierDAO {
	@SuppressWarnings("unused")
	@Autowired
	private Supplier supplier;
	@Autowired
	private SessionFactory sessionFactory;
	public SupplierDAOImpl(SessionFactory sessionfactory)
	{
		this.sessionFactory=sessionfactory;
	}

	@Transactional
	public boolean save(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().save(supplier);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}// TODO Auto-generated method stub
		return true;
	}
	@Transactional
	public boolean update(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().update(supplier);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
	}
		// TODO Auto-generated method stub
		return true;
	}
	@Transactional
	public void delete(String id) {
		Supplier SupplierToDelete = new Supplier();
		SupplierToDelete.setId(id);
			sessionFactory.getCurrentSession().delete(SupplierToDelete);
	}

	public List<Supplier> list() {
		return null;
	}

}
