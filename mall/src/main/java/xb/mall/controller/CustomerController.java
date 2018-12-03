package xb.mall.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import xb.mall.bean.IndexImage;
import xb.mall.bean.ProductInfo;
import xb.mall.bean.responseObj.ProductInfoReponse;
import xb.mall.common.Enums;
import xb.mall.service.ImageService;
import xb.mall.service.ProductService;

import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/customer")
@Slf4j
public class CustomerController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ImageService imageService;

    @GetMapping("/")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("customer_home");
        Map<String,Object> data = new HashMap<>();
        List<ProductInfo> featuresList = productService.getProductListByCollectionId(Enums.FEATUREPRODUCT.getCode());

        List<IndexImage> middleAdsList = new LinkedList<>();
        if(featuresList.size()>4){
            data.put("features1",featuresList.subList(0,4));
            data.put("features2",featuresList.subList(4,featuresList.size()));
        }else {
            data.put("features1",featuresList.subList(0,featuresList.size()));
        }
        try {
            middleAdsList = imageService.getIndexImageByMenuId(Enums.MIDDLEADS.getValue());
            data.put("middleAdsList",middleAdsList);
        } catch (Exception e){
            log.error("广告图片查询错误");
        }
        List<ProductInfoReponse> productInfoReponseList = productService.getAll();
        Map<String,List<ProductInfoReponse>> map = new HashMap<>();
        map = productInfoReponseList.stream().collect(Collectors.groupingBy(ProductInfoReponse :: getCategoryName, TreeMap::new,Collectors.toList()));
        for(Map.Entry<String,List<ProductInfoReponse>> entry:map.entrySet()){
            List<ProductInfoReponse> list = entry.getValue();
            if(list.size()>3){
                list = list.subList(0,3);
            }
            data.put(entry.getKey(),list);
        }
        modelAndView.addAllObjects(data);
        return modelAndView;
    }
}
