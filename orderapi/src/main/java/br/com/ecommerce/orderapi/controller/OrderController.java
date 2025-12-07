package br.com.ecommerce.orderapi.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ecommerce.orderapi.model.dtos.CreateOrderResponseDTO;
import br.com.ecommerce.orderapi.model.dtos.OrderResponseDTO;
import br.com.ecommerce.orderapi.model.dtos.RegisterOrderDTO;
import br.com.ecommerce.orderapi.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<CreateOrderResponseDTO> createOrder(@RequestBody RegisterOrderDTO registerOrderDTO) {
        CreateOrderResponseDTO createOrderResponseDTO = orderService.save(registerOrderDTO);
        return ResponseEntity.ok(createOrderResponseDTO);
       
    }

    @GetMapping
    public ResponseEntity<Page<OrderResponseDTO>> getAllOrders(Pageable pageable) {
        Page<OrderResponseDTO> orderResponseDTO = orderService.findAll(pageable);
        return ResponseEntity.ok(orderResponseDTO);
    }
    
}
