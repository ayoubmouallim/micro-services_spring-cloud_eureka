package ms.demo.mssproduits.web;

import ms.demo.mssproduits.dto.ProductRequestDTO;
import ms.demo.mssproduits.dto.ProductResponseDTO;
import ms.demo.mssproduits.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductRestController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<ProductResponseDTO> getProducts()
    {
     return productService.getProducts();
    }
    @GetMapping("/products/{id}")
    public ProductResponseDTO getProduct(@PathVariable String id)
    {
        return productService.getProduct(id);
    }

    @PostMapping("/products")
    public ProductResponseDTO save(@RequestBody ProductRequestDTO productRequestDTO)
    {
        return productService.save(productRequestDTO);
    }

    @PutMapping("/products")
    public ProductResponseDTO update(@RequestBody ProductRequestDTO productRequestDTO)
    {
        return productService.update(productRequestDTO);
    }








}
