package com.example.order_service.controller;

import com.example.order_service.repository.OrderRepository;
import com.example.order_service.service.OrderService;
import com.example.order_service.feign.ProductFeignClient;
import com.example.order_service.dto.ProductDTO;
import com.example.order_service.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductFeignClient productFeignClient;

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        for (Long productId : order.getProductIds()) {
            try {
                ProductDTO product = productFeignClient.getProductById(productId);
                if (product.getStock() <= 0) {
                    throw new RuntimeException("Product out of stock");
                }
            } catch (Exception e) {
                throw new RuntimeException("Error fetching product with ID: " + productId, e);
            }
        }
        order.setStatus("Pending");
        return orderRepository.save(order);
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return ResponseEntity.ok(orders);
    }

    @CrossOrigin
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Order>> getOrdersByCustomerId(@PathVariable Long customerId) {
        List<Order> orders = orderService.getOrdersByCustomerId(customerId);

        if (orders.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // No orders found for the customer
        }

        return new ResponseEntity<>(orders, HttpStatus.OK); // Orders found
    }
}
