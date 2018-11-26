package xb.order.service;

import xb.order.dto.OrderDTO;

public interface OrderService {
    OrderDTO create(OrderDTO orderDTO);

    OrderDTO finishi(String orderId);
}
