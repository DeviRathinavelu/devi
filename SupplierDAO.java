package com.devi.bags.dao;

import java.util.List;

import com.devi.bags.model.Supplier;

public interface SupplierDAO {

	public boolean create(Supplier supplier);	
    public boolean update(Supplier supplier);
    public boolean delete(String id);
    public SupplierDAO get(String id);
    public List<SupplierDAO>list();

}

