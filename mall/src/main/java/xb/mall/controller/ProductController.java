package xb.mall.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xb.mall.bean.ProductInfo;
import xb.mall.bean.responseObj.ProductInfoReponse;
import xb.mall.service.ProductService;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Value("${web.upload-path}")
    private String imgStorePath;

    @RequestMapping("/getProductInfoPaged")
    public Page<ProductInfo> getProductInfoPaged(@RequestParam String category){
        Page<ProductInfo> page = productService.getProductInfoPaged();
        return page;
    }

    @RequestMapping("/getProductInfoListByCategoryName")
    public List<ProductInfoReponse> getProductInfoList(@RequestParam String categoryName){
        List<ProductInfoReponse> list = productService.getProductListByCategoryName(categoryName);
        return list;
    }

    @GetMapping(value = "/preview",produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity preview(@RequestParam String productId) throws FileNotFoundException {
        InputStream inputStream = new FileInputStream(new File(imgStorePath+productId+".jpg"));
        InputStreamResource inputStreamResource = new InputStreamResource(inputStream);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity(inputStreamResource,headers, HttpStatus.OK);
    }

}
