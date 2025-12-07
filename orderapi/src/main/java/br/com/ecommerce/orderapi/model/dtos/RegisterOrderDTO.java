package br.com.ecommerce.orderapi.model.dtos;

import java.math.BigDecimal;
import java.util.List;

public record RegisterOrderDTO(List<Long> products, BigDecimal total) {
}
