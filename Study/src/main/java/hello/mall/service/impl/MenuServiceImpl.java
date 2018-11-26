package hello.mall.service.impl;

import hello.mall.Model.Menu;
import hello.mall.dao.MenuDao;
import hello.mall.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MenuServiceImpl implements MenuService{
    @Autowired
    private MenuDao menuDao;

    @Override
    public List<Menu> selectAllFMenu() {
        List<Menu> menuList = menuDao.selectAllFMenu();
        return menuList;
    }

    @Override
    public List<Menu> selectSMenu(String id) {
        Menu menu = new Menu();
        menu.setId(id);
        List<Menu> sMenuList = menuDao.selectSMenu(menu);
        return sMenuList;
    }

    @Override
    public List<Menu> test() {
        Map<String,Object> map =new HashMap<>();
        map.put("name","abg");
        map.put("pid",2);

        return menuDao.findOnlyStoreLi(map);
        //return menuDao.findOnlyStoreLi2(map);
    }


}
