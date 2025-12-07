package br.com.ecommerce.orderapi.service.clients;

import br.com.ecommerce.orderapi.model.dtos.ProductResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service", url = "${product.service.url}")
public interface ProductClient {

    @GetMapping("/{id}")
    ProductResponseDTO findById(@PathVariable("id") Long id);
}
