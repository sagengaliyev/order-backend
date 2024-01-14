package kz.sagengaliyev.orderapi.facade;

import kz.sagengaliyev.orderapi.dto.OrderCreationDTO;
import kz.sagengaliyev.orderapi.dto.OrderDTO;
import kz.sagengaliyev.orderapi.mapper.OrderMapper;
import kz.sagengaliyev.orderapi.model.Order;
import kz.sagengaliyev.orderapi.pagination.PageDTO;
import kz.sagengaliyev.orderapi.pagination.PageableFactory;
import kz.sagengaliyev.orderapi.service.OrderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderFacade {
    private final OrderService orderService;
    private final OrderMapper orderMapper;

    public OrderFacade(OrderService orderService, OrderMapper orderMapper) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
    }

    public Order save(OrderCreationDTO dto) {
        Order order = orderMapper.toEntity(dto);
        return orderService.save(order);
    }

    public OrderDTO findById(Long id) {
        return orderMapper.toDto(orderService.findById(id));
    }

    public PageDTO<OrderDTO> findAll(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageableFactory.create(pageNumber, pageSize);
        Page<OrderDTO> applications = orderService.findAll(pageable).map(orderMapper::toDto);
        return new PageDTO<>(applications);
    }
}
