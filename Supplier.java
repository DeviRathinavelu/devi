package com.devi.bags.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Table(name="Supplier")
@Component

public class Supplier {
	@Id
	private String Id;
	private String Name;
	private String Address;
	@OneToMany(mappedBy="supplier",fetch=FetchType.EAGER)
	private Set<Product> products;
	public Set<Product> getproducts() {
	return products;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
}