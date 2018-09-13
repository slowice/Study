package hello.listener;

import hello.messageAndResource.Example;
import hello.util.LogUtil;
import hello.util.SpringUtil;
import hello.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.io.UnsupportedEncodingException;

public class StartListener implements ApplicationListener<ContextRefreshedEvent>{
    private  Logger logger = LoggerFactory.getLogger(StartListener.class);

    /**
        Context完全启动才会触发
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        logger.info(LogUtil.formatLog(this.getClass().getName()));
        Example example = SpringUtil.getBean("example",Example.class);
        try {
            System.out.println(example.getMessage("123"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
