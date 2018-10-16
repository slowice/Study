package xb.mall.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import xb.mall.bean.Menu;

public interface MenuRepository extends JpaRepository<Menu,String> {

}
