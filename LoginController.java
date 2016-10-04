package com.devi.bags.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.devi.bags.dao.CategoryDAO;
import com.devi.bags.dao.ProductDAO;
import com.devi.bags.dao.SupplierDAO;
import com.devi.bags.dao.UserDAO;
import com.devi.bags.model.Category;
import com.devi.bags.model.Product;
import com.devi.bags.model.Register;
import com.devi.bags.model.Supplier;

@Controller
public class LoginController {
@Autowired
private CategoryDAO categorydao;
@Autowired
private Category category;
@Autowired
private ProductDAO productdao;
@Autowired
private Product product;
@Autowired
private SupplierDAO supplierdao;
@Autowired
private Supplier supplier;
@Autowired
private UserDAO userdao;
@Autowired
Register register;
@Autowired
private HttpSession session; 
@RequestMapping ("/login")
public ModelAndView login(@RequestParam(value="username") String username,
		                  @RequestParam(value="password") String password)
{
	register= userdao.isValidUser(username, password);
ModelAndView mv=null;
if(register==null)
{
mv=new ModelAndView("Home");
mv.addObject("errorMessage","Invalid credentials.. please try again");
}
else
{
	if(register.getRole().equals("ROLE_ADMIN"))
	{
		mv=new ModelAndView("admin");
		session.setAttribute("categoryList",categorydao.list());
		session.setAttribute("supplierList",supplierdao.list());
		session.setAttribute("productList",productdao.list());
		
		session.setAttribute("category",category);
		session.setAttribute("supplier",supplier);
		session.setAttribute("product",product);
    }
	else
		if(register.getRole().equals("ROLE_USER"))
		{
			mv=new ModelAndView("Home");
			session.setAttribute("username",register.getUsername());
			session.setAttribute("username",register.getUsername());
		}
}
return mv;
}
}

