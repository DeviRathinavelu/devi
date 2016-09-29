package com.devi.bags.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Table(name="Category")
@Component
public class Category
{
	@Id
	private String Id;
	private String Name;
	private String Description;
	@OneToMany(mappedBy="category",fetch=FetchType.EAGER)
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
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
}