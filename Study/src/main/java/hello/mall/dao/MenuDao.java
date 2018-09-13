package hello.mall.dao;

import hello.mall.Model.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuDao {
    List<Menu> selectAllFMenu();
    List<Menu> selectSMenu(Menu menu);
}
