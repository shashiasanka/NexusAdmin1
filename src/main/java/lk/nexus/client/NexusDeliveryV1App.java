package lk.nexus.client;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;



@SpringBootApplication	
public class NexusDeliveryV1App	extends SpringBootServletInitializer {
//public class NexusClientApp {
//	@Autowired
//	ExpenseRepository repository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(NexusDeliveryV1App.class, args);
		
	}
	

//	@Override
//	public void run(String... args) throws Exception {
//		
//		repository.save(new Expense("breakfast", 5));
//		repository.save(new Expense("coffee", 2));
//		repository.save(new Expense("New SSD drive", 200));
//		repository.save(new Expense("Tution for baby", 350));
//		repository.save(new Expense("Some apples", 5));
//		
//		Iterable<Expense> iterator = repository.findAll();
//		
//		System.out.println("All expense items: ");
//		iterator.forEach(item -> System.out.println(item));
//		
//		List<Expense> breakfast = repository.findByItem("breakfast");
//		System.out.println("\nHow does my breakfast cost?: ");
//		breakfast.forEach(item -> System.out.println(item));
//		
//		List<Expense> expensiveItems = repository.listItemsWithPriceOver(200);
//		System.out.println("\nExpensive Items: ");
//		expensiveItems.forEach(item -> System.out.println(item));
//		
//	}
}
