package Test.Bags;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.devi.bags.dao.CategoryDAO;
import com.devi.bags.model.Category;


public class CategoryTest {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext Context = new AnnotationConfigApplicationContext();
		Context.scan("com");
		Context.refresh();
		CategoryDAO categorydao = (CategoryDAO) Context.getBean("categorydao");
		Category category = (Category) Context.getBean("category");
		category.setId("033");
		category.setName("laptop bags");
		category.setDescription("happy feel");
		categorydao.save(category);
		System.out.println("Objects are created successfully");
	}

}