package Test.Bags;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.devi.bags.dao.SupplierDAO;
import com.devi.bags.model.Supplier;

public class SupplierTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext Context = new AnnotationConfigApplicationContext();
		Context.scan("com");
		Context.refresh();
		SupplierDAO supplierdao = (SupplierDAO) Context.getBean("supplierdao");
		Supplier supplier = (Supplier) Context.getBean("supplier");
		supplier.setId("002");
		supplier.setName("andy");
		supplier.setAddress("moritious");
		supplierdao.save(supplier);
		System.out.println("Objects are created successfully");
	}

}
