package Test.Bags;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.devi.bags.dao.UserDAO;
import com.devi.bags.model.Register;

public class UserTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("com");
		context.refresh();

		UserDAO userdao = (UserDAO) context.getBean("userdao");
		Register register = (Register) context.getBean("register");

		register.setFirstname("sree");
		register.setLastname("devi");
		register.setUsername("candy");
		register.setPassword("123");
		register.setEmail("sreedevi@gmail.com");
		register.setPhone("9876543210");
		register.setAddress("chennai city");
		userdao.save(register);

		System.out.println("Data inserted into the database sucessfully");
	}
}
