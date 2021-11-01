package ms.demo.mssproduits.mappers;

import ms.demo.mssproduits.dto.ProductRequestDTO;
import ms.demo.mssproduits.dto.ProductResponseDTO;
import ms.demo.mssproduits.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product productRequestToProduct(ProductRequestDTO productRequestDTO);
    ProductResponseDTO productToProductResponse(Product product);

}
