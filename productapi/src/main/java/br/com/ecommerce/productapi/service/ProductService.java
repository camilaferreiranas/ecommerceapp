package br.com.ecommerce.productapi.service;

import br.com.ecommerce.productapi.model.dtos.CreateProductResponseDTO;
import br.com.ecommerce.productapi.model.dtos.ProductResponseDTO;
import br.com.ecommerce.productapi.model.dtos.RegisterProductRequestDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    CreateProductResponseDTO save(RegisterProductRequestDTO dto);
    Page<ProductResponseDTO> findAll(Pageable pageable);
    ProductResponseDTO findById(Long id);
}
