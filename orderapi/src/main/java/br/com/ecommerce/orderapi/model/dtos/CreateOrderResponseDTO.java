package br.com.ecommerce.orderapi.model.dtos;

import java.util.UUID;

public record CreateOrderResponseDTO(String message, UUID id) {
}
