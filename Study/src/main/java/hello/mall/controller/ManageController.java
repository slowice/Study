package hello.mall.controller;

import hello.mall.Model.Menu;
import hello.mall.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class    ManageController {
    @Autowired
    private MenuService menuService;

    @RequestMapping("/mall/manage")
    public ModelAndView manage(@RequestParam(value="m",required=false)String m, @RequestParam(value="a",required=false)String a){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("manage");
        List<Menu> menuList = menuService.selectAllFMenu();
        modelAndView.addObject("menuList",menuList);

        if(null==m){return modelAndView;}

        switch (m){
            case "products":
                switch (a){
                    case "products":
                        List<Menu> sMenuList = menuService.selectSMenu("1");
                        modelAndView.addObject("title","产品");
                        modelAndView.addObject("index","1");
                        modelAndView.addObject("sIndex","0");
                        modelAndView.addObject("sMenuList",sMenuList);
                }

        }
        return modelAndView;
    }



    @RequestMapping("/mall/manage/getSMenu")
    @ResponseBody
    public List<Menu> getSMenu(){
       // List<Menu> sMenuList = menuService.selectSMenu(id);
       //return sMenuList;
        List<Menu> list = menuService.test();
        return list;
    }
}
