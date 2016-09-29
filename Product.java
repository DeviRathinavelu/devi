package com.devi.bags.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Table(name="Product")
@Component
public class Product {

	@Id
	private String Id;
	private String Name;
	private int price;
	@ManyToOne
	@JoinColumn(name="category_id",insertable=false,updatable=false,nullable=false)
	private Category category;
	@ManyToOne
	@JoinColumn(name="supplier_id",insertable=false,updatable=false,nullable=false)
	private Supplier supplier;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
	
