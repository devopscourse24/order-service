package org.elfn.order.mappers;

import org.elfn.order.dtos.OrderDTO;
import org.elfn.order.entities.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);
    @Mapping(source = "foodItemList", target = "foodItemList")
    Order mapOrderDTOToOrder(OrderDTO orderDTO);

    @Mapping(source = "foodItemList", target = "foodItemList")
    OrderDTO mapOrderToOrderDTO(Order order);

}
