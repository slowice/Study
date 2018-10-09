package xb.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xb.order.dataobject.OrderMaster;

public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {

}
