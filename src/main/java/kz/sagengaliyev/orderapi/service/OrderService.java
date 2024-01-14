package kz.sagengaliyev.orderapi.service;

import kz.sagengaliyev.orderapi.model.Order;
import kz.sagengaliyev.orderapi.repository.OrderRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order save(Order order) {
        return orderRepository.save(order);
    }

    public Page<Order> findAll(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }

    public Order findById(Long id) {
        return orderRepository.findById(id).orElseThrow();
    }
}
