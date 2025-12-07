package br.com.ecommerce.orderapi.service;

import br.com.ecommerce.orderapi.model.Order;
import br.com.ecommerce.orderapi.model.Status;
import br.com.ecommerce.orderapi.model.dtos.CreateOrderResponseDTO;
import br.com.ecommerce.orderapi.model.dtos.OrderResponseDTO;
import br.com.ecommerce.orderapi.model.dtos.ProductResponseDTO;
import br.com.ecommerce.orderapi.model.dtos.RegisterOrderDTO;
import br.com.ecommerce.orderapi.repository.OrderRepository;
import br.com.ecommerce.orderapi.service.clients.ProductClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductClient productClient;

    public OrderServiceImpl(OrderRepository orderRepository, ProductClient productClient) {
        this.orderRepository = orderRepository;
        this.productClient = productClient;
    }

    @Override
    public CreateOrderResponseDTO save(RegisterOrderDTO dto) {
        Order orderToSave = new Order();
        orderToSave.setStatus(Status.CREATED);
        orderToSave.setCreatedAt(LocalDateTime.now());
        orderToSave.setTotal(dto.total());
        orderToSave.setProducts(dto.products());
        var entityToSave = orderRepository.save(orderToSave);
        return new CreateOrderResponseDTO("Pedido criado com sucesso", entityToSave.getId());
    }

    @Override
    public Page<OrderResponseDTO> findAll(Pageable pageable) {
         var ordersPage = orderRepository.findAll(pageable);
        return ordersPage.map(order -> {
            List<ProductResponseDTO> products = order.getProducts()
                    .stream()
                    .map(productClient::findById)
                    .toList();

            return new OrderResponseDTO(
                    order.getId(),
                    order.getCreatedAt(),
                    order.getTotal(),
                    products

            );
        });

    }
}
