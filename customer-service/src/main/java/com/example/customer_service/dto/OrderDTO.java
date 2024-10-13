package com.example.customer_service.dto;

public class OrderDTO {

    private Long id;
    private String status;
    private Long customerId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public OrderDTO() {
    }

    public OrderDTO(Long id, String status, Long customerId) {
        this.id = id;
        this.status = status;
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", customerId=" + customerId +
                '}';
    }
}
