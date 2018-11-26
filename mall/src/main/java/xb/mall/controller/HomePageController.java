package xb.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xb.mall.bean.ProductInfo;
import xb.mall.common.Enums;
import xb.mall.common.vo.ResultVO;
import xb.mall.common.vo.ResultVOUtil;
import xb.mall.service.ProductCollectionService;
import xb.mall.service.ProductService;

import java.util.List;

@Controller
@RequestMapping("/homepage")
public class HomePageController {
    @Autowired
    ProductService productService;

    @Autowired
    ProductCollectionService productCollectionService;

    @GetMapping("/features")
    public String features(){
        return "manage_homepage_feature";
    }

    /**
     * 添加特色产品
     * @param productId
     * @return
     */
    @PostMapping("/features/add")
    public String addFeature(@RequestParam String productId){
        ProductInfo productInfo = productService.getProductInfoById(productId);
        if(null!=productInfo){
            productCollectionService.addRelation(productInfo.getId(), Enums.FEATUREPRODUCT.getCode());
        }
        return null;
    }

    /**
     * 查询特色产品列表
     * @return
     */
    @GetMapping("/features/getAll")
    @ResponseBody
    public ResultVO getAllFeatures(){
        List<ProductInfo> obj = productService.getProductListByCollectionId(Enums.FEATUREPRODUCT.getCode());
        return ResultVOUtil.success(obj);
    }

    @PostMapping("/features/delete")
    @ResponseBody
    public ResultVO deleteFeatures(@RequestParam String productId){
        productCollectionService.deleteRelation(productId,Enums.FEATUREPRODUCT.getCode());
        return ResultVOUtil.success(null);
    }
}
