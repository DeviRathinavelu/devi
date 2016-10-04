package com.devi.bags.dao;
import java.util.List;

import com.devi.bags.model.Register;

public interface UserDAO {
	public boolean save(Register register);
   public boolean update(Register register);
    public boolean delete(String username);
    public Register get(String username);
	public List<Register> list();
	public Register isValidUser(String id, String password);
}
