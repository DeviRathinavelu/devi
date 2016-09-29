package com.devi.bags.dao;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.devi.bags.model.Category;


@Repository
public class CategoryDAOImpl implements CategoryDAO {
	@Autowired
	private Category category;
	@Autowired
	private SessionFactory sessionFactory;
	
	public CategoryDAOImpl(SessionFactory sessionfactory)
	{
		this.sessionFactory=sessionfactory;
	}
@Transactional
	public boolean save(Category Category) {
		try {
			sessionFactory.getCurrentSession().save(category);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
			// TODO Auto-generated method stub
		return true;
	}
@Transactional
	public boolean update(Category Category) {
		try {
			sessionFactory.getCurrentSession().update(category);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
	}
		// TODO Auto-generated method stub
		return true;
	}	
@Transactional
	public void delete(String id) {
		Category CategoryToDelete = new Category();
		CategoryToDelete.setId(id);
			sessionFactory.getCurrentSession().delete(CategoryToDelete);
	}

@Transactional	
	@SuppressWarnings("null")
	public CategoryDAO get(String id) {
		String hql = "from Category where id='" + id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Category> list =(List<Category>)query;
		if (list != null || list.isEmpty()) {
			return null;
		}
		// TODO Auto-generated method stub
		return (CategoryDAO) list.get(0);
	}
	@Transactional
	public List<CategoryDAO> list() {
		// TODO Auto-generated method stub
		return null;
	}

}