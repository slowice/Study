package xb.mall.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import xb.mall.bean.Menu;
import xb.mall.bean.ProductInfo;
import xb.mall.dao.ProductInfoRepository;
import xb.mall.service.MenuService;
import xb.mall.service.ProductService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/mall/manage")
public class ManageController {
    @Autowired
    private MenuService menuService;

    @Autowired
    private ProductService productService;

    @RequestMapping("/")
    public ModelAndView manage(@RequestParam(value="m",required=false)String m, @RequestParam(value="a",required=false)String a){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("manage_main");
        return modelAndView;
    }

    @RequestMapping("/product")
    public ModelAndView getProductList(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("manage_product_list");
        modelAndView.addObject("menu","product");
        return modelAndView;
    }

    @RequestMapping("/order")
    public ModelAndView getOrderList(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("manage_order_list");
        modelAndView.addObject("menu","order");

        return modelAndView;
    }
}
