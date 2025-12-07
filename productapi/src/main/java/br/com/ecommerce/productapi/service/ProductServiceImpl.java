package br.com.ecommerce.productapi.service;

import br.com.ecommerce.productapi.model.Product;
import br.com.ecommerce.productapi.model.dtos.CreateProductResponseDTO;
import br.com.ecommerce.productapi.model.dtos.ProductResponseDTO;
import br.com.ecommerce.productapi.model.dtos.RegisterProductRequestDTO;
import br.com.ecommerce.productapi.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public CreateProductResponseDTO save(RegisterProductRequestDTO dto) {
        Product product = new Product();
        product.setName(dto.name());
        product.setDescription(dto.description());
        product.setPrice(dto.price());
        product.setCategory(dto.category());
        var productSaved = repository.save(product);
        return new CreateProductResponseDTO("Produto salvo com sucesso",
                productSaved.getId(), productSaved.getName());
    }

    @Override
    public Page<ProductResponseDTO> findAll(Pageable pageable) {
        var productList = repository.findAll(pageable);
        return productList.map(product -> new ProductResponseDTO(product.getId(), product.getName(),
                product.getPrice(), product.getCategory().name()));
    }

    @Override
    public ProductResponseDTO findById(Long id) {
        var product = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        return new ProductResponseDTO(product.getId(), product.getName(),
                product.getPrice(), product.getCategory().name());
    }
}
