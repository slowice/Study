package xb.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xb.order.dataobject.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {
}
