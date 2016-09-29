package com.devi.bags.dao;

import java.util.List;

import com.devi.bags.model.Product;

public interface ProductDAO {
	public boolean save(Product product);	
    public boolean update(Product product);
    public void delete(String id);
    public ProductDAO get(String id);
    public List<ProductDAO>list();

}

