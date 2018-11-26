package hello.mall.dao;

import hello.mall.Model.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MenuDao {

    List<Menu> selectAllFMenu();
    List<Menu> selectSMenu(Menu menu);

    List<Menu> findOnlyStoreLi(Map<String ,Object> map);
    List<Menu> findOnlyStoreLi2(Map<String ,Object> map);
}
