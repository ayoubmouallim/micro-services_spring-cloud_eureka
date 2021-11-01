package ms.demo.mssproduits.services;

import ms.demo.mssproduits.dto.ProductRequestDTO;
import ms.demo.mssproduits.dto.ProductResponseDTO;

import java.util.List;

public interface ProductService {
      ProductResponseDTO save(ProductRequestDTO productRequestDTO);
      ProductResponseDTO update(ProductRequestDTO productRequestDTO);
      List<ProductResponseDTO> getProducts();
      ProductResponseDTO getProduct(String id);


}
