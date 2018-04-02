package hello.util;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import java.util.Properties;

public class SSHUtil {
    private ChannelSftp channelSftp;
    private Session session = null;
    private static final int TIME_OUT = 60000;

    public SSHUtil(){
        SSHUtil.SSHConfiguration conf = new SSHUtil.SSHConfiguration();
        conf.setHost("182.180.50.100");
        conf.setUsername("root");
        conf.setPassword("%TGB6yhn");
        conf.setPort(22);

        JSch jSch = new JSch();
        try {
            session = jSch.getSession(conf.getUsername(),conf.getHost(),conf.getPort());
            session.setPassword(conf.getPassword());
            Properties config = new Properties();
            config.put("StrictHostKeyChecking","no");
            session.setConfig(config);
            session.setTimeout(TIME_OUT);
            session.connect();
        } catch (JSchException e) {
            e.printStackTrace();
        }
    }

    public void close(){
        session.disconnect();
    }

    public void download(String fileName, String localPath) throws Exception{
        channelSftp = (ChannelSftp)session.openChannel("sftp");
        channelSftp.connect();
        channelSftp.get(fileName,localPath);
        System.out.println("download success");
        channelSftp.quit();
        close();
    }


    public static class SSHConfiguration{
        private String host;
        private String username;
        private String password;
        private int port;

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public int getPort() {
            return port;
        }

        public void setPort(int port) {
            this.port = port;
        }
    }

}
