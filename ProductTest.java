package Test.Bags;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.devi.bags.dao.ProductDAO;
import com.devi.bags.model.Product;

public class ProductTest {
	public static void main(String[] args) {

		// get domain and dao instance without creating a new operator so create
		// context
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		// mention the package from where context have to get instance
		context.scan("com");
		context.refresh();

		ProductDAO productdao = (ProductDAO) context.getBean("productdao");
		Product product = (Product) context.getBean("product");

		// insert the data into table
		product.setId("123");
		product.setName("strolleys");
		product.setPrice(700);
		product.setDescription("Exciting travel");
		product.setCategory_id("111");
		product.setSupplier_id("222");
		// perform save crud operations
		productdao.save(product);

		System.out.println("product inserted successfully");

	}
}


