package com.example.customer_service.feign;


import com.example.customer_service.dto.OrderDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "order-service")
public interface OrderFeignClient {

    @GetMapping("/orders/customer/{customerId}")
    List<OrderDTO> getOrdersByCustomerId(@PathVariable("customerId") Long customerId);
}
