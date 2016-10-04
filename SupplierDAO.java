package com.devi.bags.dao;

import java.util.List;

import com.devi.bags.model.Product;
import com.devi.bags.model.Supplier;

public interface SupplierDAO {

	public boolean save(Supplier supplier);	
    public boolean update(Supplier supplier);
    public void delete(String id);
    public List<Supplier>list();
}

