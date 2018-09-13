package xb.product.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xb.product.VO.ProductInfoVO;
import xb.product.VO.ProductVO;
import xb.product.VO.ResultVO;
import xb.product.dataobject.ProductCategory;
import xb.product.dataobject.ProductInfo;
import xb.product.service.CategoryService;
import xb.product.service.ProductService;
import xb.product.utils.ResultVOUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;
    /**
     *  1.查询所有在架商品
     *  2.查询类目type列表
     *  3.查询类目
     *  4.构造数据
     */
    @GetMapping("/list")
    public ResultVO<ProductVO> list(){
        //查询所有上架商品
        List<ProductInfo>  productInfoList = productService.findUpAll();
        //获得所有商品分类
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(ProductInfo::getCategoryType)
                .collect(Collectors.toList());
        //从数据库查询类目
        List<ProductCategory> productCategoryList = categoryService.findCategoryTypeIn(categoryTypeList);

        //构造数据结构
        List<ProductVO> productVOList = new ArrayList<>();
        for(ProductCategory productCategory:productCategoryList){
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for(ProductInfo productInfo:productInfoList){
                if(productCategory.getCategoryType().equals(productInfo.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setList(productInfoVOList);
            productVOList.add(productVO);
        }
        ResultVO resultVO = ResultVOUtil.success(productVOList);
        return resultVO;
    }

    //订单服务调用，根据商品ID集合查询商品信息集合
    @PostMapping("/listForOrder")
    public List<ProductInfo> listForOrder(@RequestBody List<String> productIdList){
        return productService.findList(productIdList);
    }
}
