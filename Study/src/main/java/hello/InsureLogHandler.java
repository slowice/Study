
package hello;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import hello.dao.InsureLogDao;
import hello.logshandler.entity.InsureLog;
import hello.util.SSHUtil;
import hello.util.SpringUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;


/**
 * 下载保险日志并解析
 * 20180224 version1.0 完成基础功能建设
 * version2.0 1.将下载与解析换成生产者消费者模式 2.添加定时任务
 * @author xb
 */

//@SpringBootApplication
public class InsureLogHandler {
    private static String fileName;
    private static final String LOCAL_PATH = "E://test/";
    private static final String SERVER_PATH = "/pcccmall/logs/";
    private static final String PAY_SEND_KEY = "*保险支付请求参数";
    private static final String PAY_RECEIVE_KEY = "*查询支付结果请求参数为";

    private static void init(){
        fileName = "mcustomer-mcustomer.log.20180209";
    }

    /**
     * 下载对应的日志文件到本地目录
     */
    public static void download(){
        File file = new File(LOCAL_PATH + fileName);
        if(file.exists()){
            //logger.info("日志文件已存在,filename:"+fileName);
            return;
        }
        try {
            SSHUtil sshUtil = new SSHUtil();
            sshUtil.download(SERVER_PATH + fileName,LOCAL_PATH);
            //logger.info("文件下载成功!filename:"+fileName);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 分析下载的保险日志,并得到List<InsureLog>
     */
    public static List<InsureLog> analysis() throws IOException {
        File file = new File(LOCAL_PATH + fileName);
        if(!file.exists()){
            //logger.error("文件不存在！filename:"+fileName);
            throw new FileNotFoundException("文件不存在！");
        }
        List<InsureLog> list = new ArrayList<InsureLog>();
        Scanner scanner = new Scanner(file,"utf-8");
        int lineIndex = 0;
        while(true){
            if(scanner.hasNext() == false){
                break;
            }
            String s = scanner.nextLine();
            lineIndex++;
            if(s.contains(PAY_SEND_KEY)){
                //支付请求参数
                String paySend = s.substring(s.indexOf("{"),s.indexOf("}")+1);
                //支付返回参数
                String payReceive = s.substring(s.lastIndexOf("{"),s.lastIndexOf("}")+1);
                ObjectMapper objectMapper = new ObjectMapper();
                Map<String,String> map = objectMapper.readValue(paySend,Map.class);
                String mrchntTraceNo = map.get("MrchntTraceNo").toString();
                String orderId = mrchntTraceNo.substring(0,mrchntTraceNo.length()-2);
                InsureLog insureLog = new InsureLog();
                insureLog.setOrderId(orderId);
                insureLog.setMrchntTraceNo(mrchntTraceNo);
                insureLog.setPaySend(paySend);
                insureLog.setPayReceive(payReceive);
                list.add(insureLog);
            }
        }
        return list;
    }

    /**
     * 持久化分析得到的InsureLog
     */
    public static void persist(List<InsureLog> list){
        InsureLogDao insureLogDao = (InsureLogDao)SpringUtil.getBean("insureLogDao");
        for(InsureLog insureLog:list){
            insureLogDao.insert(insureLog);
        }
        //insureLogDao.insertBatch(list);
    }

    public static void main(String[] args) throws IOException {
        SpringApplication.run(InsureLogHandler.class);
        init();
        download();
        List<InsureLog> list = analysis();
        persist(list);
    }


}

