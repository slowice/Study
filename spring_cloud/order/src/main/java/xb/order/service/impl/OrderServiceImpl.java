package xb.order.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xb.order.dataobject.OrderMaster;
import xb.order.dto.OrderDTO;
import xb.order.enums.OrderStatus;
import xb.order.enums.PayStatus;
import xb.order.repository.OrderDetailRepository;
import xb.order.repository.OrderMasterRepository;
import xb.order.service.OrderService;
import xb.order.utils.KeyUtil;

import java.math.BigDecimal;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMasterRepository orderMasterRepository;
    @Autowired
    OrderDetailRepository orderDetailRepository;
    /*1.参数校验
    2.查询商品信息
    3.计算总价
    4.扣库存
    5.订单入库*/
    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(KeyUtil.genUniqueKey());
        BeanUtils.copyProperties(orderDTO,orderMaster);
        orderMaster.setOrderAmount(new BigDecimal(5));
        orderMaster.setOrderStatus(OrderStatus.NEW.getCode());
        orderMaster.setPayStatus(PayStatus.WAIT.getCode());
        orderMasterRepository.save(orderMaster);

        return orderDTO;
    }
}
