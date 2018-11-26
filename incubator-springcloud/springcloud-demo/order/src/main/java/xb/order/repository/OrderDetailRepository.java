package xb.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xb.order.dataobject.OrderDetail;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {

    List<OrderDetail> findByOrderId(String orderId);
}
