package kz.sagengaliyev.orderapi.mapper;

import kz.sagengaliyev.orderapi.dto.OrderCreationDTO;
import kz.sagengaliyev.orderapi.dto.OrderDTO;
import kz.sagengaliyev.orderapi.model.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper{
    Order toEntity(OrderCreationDTO dto);
    OrderDTO toDto(Order entity);
}
