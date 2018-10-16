package xb.mall.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import xb.mall.bean.ProductInfo;

import java.util.List;

public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {
}
