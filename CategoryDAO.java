package com.devi.bags.dao;

import java.util.List;

import com.devi.bags.model.Category;

public interface CategoryDAO {
	public boolean create(Category Category);	
    public boolean update(Category Category);
    public boolean delete(String id);
    public CategoryDAO get(String id);
    public List<CategoryDAO>list();

}

