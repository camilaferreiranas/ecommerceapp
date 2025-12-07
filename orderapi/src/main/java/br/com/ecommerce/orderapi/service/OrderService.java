package br.com.ecommerce.orderapi.service;

import br.com.ecommerce.orderapi.model.dtos.CreateOrderResponseDTO;
import br.com.ecommerce.orderapi.model.dtos.OrderResponseDTO;
import br.com.ecommerce.orderapi.model.dtos.RegisterOrderDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface OrderService {

    CreateOrderResponseDTO save(RegisterOrderDTO dto);
    Page<OrderResponseDTO> findAll(Pageable pageable);
}
