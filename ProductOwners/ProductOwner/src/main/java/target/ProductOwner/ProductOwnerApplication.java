package target.ProductOwner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import target.ProductOwner.model.Owner;
import target.ProductOwner.repository.OwnerRepository;

@SpringBootApplication
public class ProductOwnerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProductOwnerApplication.class, args);
	}

	@Autowired
	private OwnerRepository ownerRepository;

	@Override
	public void run(String... args) throws Exception {
		Owner owners = new Owner();
		owners.setOwnerName("Ram");
		owners.setProductId(1);
		owners.setProductName("System");
		ownerRepository.save(owners);

		Owner owners1 = new Owner();
		owners1.setOwnerName("John");
		owners1.setProductId(2);
		owners1.setProductName("Software");
		ownerRepository.save(owners1);
	}
}
