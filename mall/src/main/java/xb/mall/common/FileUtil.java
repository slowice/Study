package xb.mall.common;

import org.apache.tomcat.util.http.fileupload.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileUtil {

    public static void cleanDir(String path) throws IOException {
        File file = new File(path);
        FileUtils.cleanDirectory(file);
    }
}
