package hello.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SocketTest {
    public static void main(String[] args) {
        test();
    }
    public static void test(){
        Thread b = new Thread(new Server());
        b.start();
        Thread a = new Thread(new Client());
        a.start();

    }
    static class Client implements Runnable {
        public static String _pattern = "yyyy-MM-dd HH:mm:ss SSS";
        public static SimpleDateFormat format = new SimpleDateFormat(_pattern);
        // 设置超时间
        public static int _sec = 5;
        int n=0;
        Socket socket ;
        @Override
        public void run() {
            while (true){
                try {
                    /*socket= new Socket("127.0.0.1",9000);
                    Writer writer = new OutputStreamWriter(socket.getOutputStream());
                    writer.write(n++);
                    Thread.sleep(2000);
                    System.out.println("client end : " + n);
                    writer.flush();*/
                    // 与服务端建立连接
                    socket = new Socket("127.0.0.1", 8001);
                    socket.setSoTimeout(20 * 1000);
                    // 往服务写数据
                    Writer writer = new OutputStreamWriter(socket.getOutputStream());
                    //\n必须有
                    writer.write("123\n");
                    writer.flush();

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    }

    static class Server implements Runnable {
        public static String _pattern = "yyyy-MM-dd HH:mm:ss SSS";
        public static SimpleDateFormat format = new SimpleDateFormat(_pattern);
        // 设置超时间
        public static int _sec = 0;
        ServerSocket server ;
        StringBuffer sb = new StringBuffer();
        @Override
        public void run() {
            try {
               /* serverSocket = new ServerSocket(9000);
                System.out.println("等待客户端连接");
                Socket socket = serverSocket.accept();
                socket.setSoTimeout(20 * 1000);
                System.out.println("建立了连接");
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                System.out.println(br.readLine());*/
                server = new ServerSocket(8001);
                System.out.println("监听建立 等你上线\n");
                Socket socket = server.accept();
                socket.setSoTimeout(20*1000);
                System.out.println("建立了链接\n");
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                System.out.println(format.format(new Date()) + "\nClient:" + br.readLine() + "\n");
             /*   Writer writer = new OutputStreamWriter(socket.getOutputStream());
                System.out.println(format.format(new Date()));
                System.out.println("我在写回复\n");

                writer.write("收到\n");

                Thread.sleep(10000);
                writer.flush();*/
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
