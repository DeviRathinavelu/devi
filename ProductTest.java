package Test.Bags;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.devi.bags.dao.ProductDAO;
import com.devi.bags.model.Product;

public class ProductTest {
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext Context = new AnnotationConfigApplicationContext();
		Context.scan("com");
		Context.refresh();
		ProductDAO productdao = (ProductDAO) Context.getBean("productdao");
		Product product = (Product) Context.getBean("product");
		product.setId("222");
		product.setName("trolleys");
		product.setPrice(1000);
		productdao.save(product);
		System.out.println("Objects are created successfully");
	}

}