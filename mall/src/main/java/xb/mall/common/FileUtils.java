package xb.mall.common;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

public class FileUtils {
    public static void storeImg(MultipartFile image,String filepath,String filename) throws IOException {
        StringBuilder pathname = new StringBuilder();
        pathname.append(filepath);
        pathname.append(filename);

        OutputStream outputStream = new FileOutputStream(new File(pathname.toString()));
        IOUtils.copy(image.getInputStream(),outputStream);
//        InputStream inputStream = null;
//        BufferedOutputStream bos = null;
//        if(null!=image && !image.isEmpty()){
//            try {
//                inputStream = new BufferedInputStream(image.getInputStream());
//                if (inputStream != null) {
//                    File file = new File(pathname.toString());
//                    bos = new BufferedOutputStream(new FileOutputStream(file));
//                    int num = 0;
//                    byte[] bytes = new byte[1024];
//                    while ((num = inputStream.read(bytes)) > 0) {
//                        bos.write(bytes, 0, num);
//                    }
//                }
//            } catch (Exception e){
//                e.printStackTrace();
//            } finally {
//                try {
//                    bos.close();
//                    inputStream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
    }
}
