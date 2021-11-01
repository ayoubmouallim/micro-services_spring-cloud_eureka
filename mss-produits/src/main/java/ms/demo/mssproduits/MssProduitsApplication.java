package ms.demo.mssproduits;

import ms.demo.mssproduits.dto.ProductRequestDTO;
import ms.demo.mssproduits.entity.Product;
import ms.demo.mssproduits.repository.ProductRepository;
import ms.demo.mssproduits.services.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class MssProduitsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MssProduitsApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductService productService, RepositoryRestConfiguration restConfiguration) {
        restConfiguration.exposeIdsFor(Product.class);
        return args -> {
            productService.save(new ProductRequestDTO("P01", "Dell Latitude", 4500, 5));
            productService.save(new ProductRequestDTO("P02", "XBOX360", 3000, 2));
            productService.save(new ProductRequestDTO("P03", "Iphone 13", 9000, 3));

            productService.getProducts().forEach(product -> {
                System.out.println(product.getName());
            });
        };
    }

}
