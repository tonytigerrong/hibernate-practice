package interview.mongodb;

import interview.mongodb.model.Customer;
import interview.mongodb.repo.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class MongoDemoApplication implements CommandLineRunner {
	@Autowired
	CustomerRepository customerRepository;
	Logger logger = LoggerFactory.getLogger(MongoDemoApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(MongoDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		customerRepository.deleteAll();
		Customer customer1 = new Customer("David","Norman");
		Customer customer2 = new Customer("Jason", "Norman");
		customerRepository.save(customer1);
		customerRepository.save(customer2);
		logger.info("customer 1&2 created !");
		Customer customer = customerRepository.findByFirstName("David");
		logger.info("get customer '{}'", customer);
		List<Customer> customers = customerRepository.findByLastName("Norman");
		customers.stream().forEach(System.out::print);

	}

}
