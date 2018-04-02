package hello.temp;

import java.io.*;

public class Hitana {

    public static void main(String[] args) throws Exception {
        Thread t = new Thread(new SubTast());
        t.start();
    }
    static class SubTast implements Runnable{
        File file = new File("E://text2.txt");
        Writer out= new OutputStreamWriter(new FileOutputStream(file));

        SubTast() throws IOException {
        }

        @Override
        public void run() {
                try {
                    while(true){
                        out.write("1");
                        out.flush();
                        Thread.sleep(1000);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    try {

                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

        }
    }
}
