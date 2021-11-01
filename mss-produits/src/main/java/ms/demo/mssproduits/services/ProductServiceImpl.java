package ms.demo.mssproduits.services;

import ms.demo.mssproduits.dto.ProductRequestDTO;
import ms.demo.mssproduits.dto.ProductResponseDTO;
import ms.demo.mssproduits.entity.Product;
import ms.demo.mssproduits.mappers.ProductMapper;
import ms.demo.mssproduits.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServiceImpl implements  ProductService{

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;

    @Override
    public ProductResponseDTO save(ProductRequestDTO productRequestDTO) {

        Product product = productMapper.productRequestToProduct(productRequestDTO);
        Product savedProduct= productRepository.save(product);

        return productMapper.productToProductResponse(savedProduct);
    }

    @Override
    public ProductResponseDTO update(ProductRequestDTO productRequestDTO) {

        Product product = productMapper.productRequestToProduct(productRequestDTO);
        Product updatedProduct= productRepository.save(product);

        return productMapper.productToProductResponse(updatedProduct);
    }

    @Override
    public List<ProductResponseDTO> getProducts() {

        List<ProductResponseDTO> productResponseDTOList = productRepository.findAll()
            .stream().map(product -> productMapper.productToProductResponse(product)).collect(Collectors.toList());

        return productResponseDTOList;
    }

    @Override
    public ProductResponseDTO getProduct(String id) {
        Product product = productRepository.findById(id).get();

        return productMapper.productToProductResponse(product);
    }
}
