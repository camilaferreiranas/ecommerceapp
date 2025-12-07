package br.com.ecommerce.productapi.model.dtos;

import java.math.BigDecimal;

public record ProductResponseDTO(Long id, String name, BigDecimal price, String category) {
}
