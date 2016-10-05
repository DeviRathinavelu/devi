package com.devi.bags.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.devi.bags.dao.CategoryDAO;
import com.devi.bags.dao.ProductDAO;
import com.devi.bags.dao.SupplierDAO;
import com.devi.bags.model.Category;
import com.devi.bags.model.Product;
import com.devi.bags.model.Supplier;

@Controller
public class AdminController {
@Autowired
private Product product;
@Autowired
private Supplier supplier;
@Autowired
private Category category;
@Autowired
private SupplierDAO supplierDAO;
@Autowired
private ProductDAO productDAO;
@Autowired
private CategoryDAO categoryDAO;

@RequestMapping("/manageCategories")
public ModelAndView Categories() {
	ModelAndView mv=new ModelAndView("/Home");
	mv.addObject("Category",category);
	mv.addObject("isAdminClickedCategories","true");
	mv.addObject("CategoryList",categoryDAO.list());
	return mv;
}

@RequestMapping("/manageSupplier")
public ModelAndView Suppliers() {
	ModelAndView mv=new ModelAndView("/Home");
	mv.addObject("Supplier",supplier);
	mv.addObject("isAdminClickedSuppliers","true");
	mv.addObject("SupplierList",supplierDAO.list());
	return mv;
}

@RequestMapping("/manageProduct")
public ModelAndView Products() {
	ModelAndView mv=new ModelAndView("/Home");
	mv.addObject("Product",product);
	mv.addObject("isAdminClickedProducts","true");
	mv.addObject("ProductList",productDAO.list());
	return mv;
}

}
