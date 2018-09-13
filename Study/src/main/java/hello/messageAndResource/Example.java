package hello.messageAndResource;

import org.springframework.context.MessageSource;
import org.springframework.util.Assert;

import java.io.UnsupportedEncodingException;
import java.util.Locale;

/**
 * 此类用于测试Message
 * 1.在spring中注入messageSource(默认为ResourceBundleMessageSource类)
 * 2.在ResourceBundleMessageSource中的basenames为一个list，这个list中存放的是文件名称
 * 3.注入了文件名后，可以通过messageSource.getMessage方法来读取文件中所存储的 k/v
 */
public class Example {
    private MessageSource messageSource;

    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    private void init(){
        Assert.notNull(messageSource,"messageSource should not be null");
    }

    public String getMessage(String messageCode) throws UnsupportedEncodingException {
        String originMessage = messageSource.getMessage("argument.required",new Object[]{"userDao","studentDao"},"defaultValue", Locale.SIMPLIFIED_CHINESE);
        //byte[] byteArr = originMessage.getBytes("UTF-8");
        //String originMessageUTF8 = new String(byteArr,"UTF-8");
        return originMessage;
    }
}
