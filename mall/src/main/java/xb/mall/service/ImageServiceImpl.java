package xb.mall.service;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import xb.mall.bean.IndexImage;
import xb.mall.common.ImageUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {
    @Value("${web.upload-path}")
    private String imgStorePath;

    @Override
    public List<IndexImage> getIndexImageByMenuId(String menuId) throws Exception {
        List<IndexImage> indexImageList = new LinkedList<>();
        String filePath = imgStorePath + menuId + "/";
        List<File> fileList = ImageUtil.getFiles(filePath);
        InputStream inputStream=null;
        try {
            for (int i =0;i<fileList.size();i++) {
                inputStream = new FileInputStream(fileList.get(i));
                int count = 0;
                while (count == 0) {
                    count = inputStream.available();
                }
                byte[] data = new byte[count];
                inputStream.read(data);
                String base64 = new String(Base64.encodeBase64(data));
                IndexImage indexImage = new IndexImage();
                indexImage.setIndex(i);
                indexImage.setImgStr(base64);
                indexImageList.add(indexImage);
            }
        }catch (Exception e){
        }finally {
            inputStream.close();
        }

        return indexImageList;
    }
}
