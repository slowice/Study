package xb.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import xb.mall.bean.ProductInfo;
import xb.mall.common.Enums;
import xb.mall.service.ProductService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("customer_home");
        Map<String,Object> data = new HashMap<>();
        List<ProductInfo> featuresList = productService.getProductListByCollectionId(Enums.FEATUREPRODUCT.getCode());
        if(featuresList.size()>4){
            data.put("features1",featuresList.subList(0,4));
            data.put("features2",featuresList.subList(4,featuresList.size()));
        }else {
            data.put("features1",featuresList.subList(0,featuresList.size()));
        }
        modelAndView.addAllObjects(data);
        return modelAndView;
    }
}
