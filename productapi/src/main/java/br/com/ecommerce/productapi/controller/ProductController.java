package br.com.ecommerce.productapi.controller;

import br.com.ecommerce.productapi.model.dtos.CreateProductResponseDTO;
import br.com.ecommerce.productapi.model.dtos.ProductResponseDTO;
import br.com.ecommerce.productapi.model.dtos.RegisterProductRequestDTO;
import br.com.ecommerce.productapi.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/product")
public class ProductController {

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CreateProductResponseDTO> save(@RequestBody RegisterProductRequestDTO dto) {
        log.info("Cadastro de produto");
        CreateProductResponseDTO response = service.save(dto);
        URI location = URI.create("/product/" + response.id());
        return ResponseEntity.created(location)
                .body(response);
    }

    @GetMapping
    public ResponseEntity<Page<ProductResponseDTO>> findAll(Pageable pageable) {
        log.info("Listagem de produtos");
        return ResponseEntity.ok(service.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }   

}