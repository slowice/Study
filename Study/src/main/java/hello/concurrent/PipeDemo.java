package hello.concurrent;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class PipeDemo {
    public static void main(String[] args) throws Exception {
        PipedWriter pipedWriter = new PipedWriter();
        PipedReader pipedReader = new PipedReader();
        pipedWriter.connect(pipedReader);
        Thread showPrint = new Thread(new ShowPrint(pipedReader),"printDemo");
        showPrint.start();
        int receive;
        try {
            while((receive = System.in.read()) != -1){
                pipedWriter.write(receive);
            }
        }  finally {
            pipedWriter.close();
        }
    }

    static class ShowPrint implements Runnable{
        private PipedReader pipedReader;

        public ShowPrint(PipedReader pipedReader){
            this.pipedReader=pipedReader;
        }

        @Override
        public void run() {
            int receive;
            try {
                while((receive=pipedReader.read())!=-1){
                    System.out.print("through pipe the receive is "+(char)receive);
                }
            } catch (IOException e) {
            }
        }
    }
}
