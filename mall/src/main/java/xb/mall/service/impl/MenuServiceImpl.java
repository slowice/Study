package xb.mall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import xb.mall.bean.Menu;
import xb.mall.dao.MenuRepository;
import xb.mall.service.MenuService;

import java.util.List;
import java.util.Optional;


@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuRepository menuRepository;

    @Override
    public List<Menu> selectAllFMenu() {
        List<Menu> list = menuRepository.findAll();
        return list;
    }

    @Override
    public List<Menu> selectSMenu(String pid) {
        Menu menu = new Menu();
        menu.setPid("0");
        Example<Menu> menuExample = Example.of(menu);
        List<Menu> list = menuRepository.findAll(menuExample);
        return list;
    }
}
