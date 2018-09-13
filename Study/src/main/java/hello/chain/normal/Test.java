package hello.chain.normal;

public class Test {
    static class HandlerA extends Handler{

        @Override
        public void handleProcess() {
            System.out.println("handler A");
        }
    }

    static class HandlerB extends Handler{

        @Override
        public void handleProcess() {
            System.out.println("handler B");
        }
    }

    static class HandlerC extends Handler{

        @Override
        public void handleProcess() {
            System.out.println("handler C");
        }
    }

    public static void main(String[] args) {
        Handler a = new HandlerA();
        Handler b = new HandlerB();
        Handler c = new HandlerC();
        a.setProcessor(b);
        b.setProcessor(c);
        a.excute();
    }
}
