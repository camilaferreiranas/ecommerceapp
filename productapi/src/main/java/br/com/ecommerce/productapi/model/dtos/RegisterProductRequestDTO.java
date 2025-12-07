package br.com.ecommerce.productapi.model.dtos;

import br.com.ecommerce.productapi.model.Category;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record RegisterProductRequestDTO(@NotNull String name, String description, @NotNull BigDecimal price, Category category) {
}
