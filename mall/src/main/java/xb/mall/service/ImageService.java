package xb.mall.service;

import xb.mall.bean.IndexImage;

import java.util.List;

public interface ImageService {
    List<IndexImage> getIndexImageByMenuId(String menuId) throws Exception;
}
