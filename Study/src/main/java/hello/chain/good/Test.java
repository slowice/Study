package hello.chain.good;

import java.util.Arrays;
import java.util.List;

public class Test {
    static class ChainHandlerA extends ChainHandler{
        @Override
        protected void handleProcess() {
            System.out.println("A");
        }
    }

    static class ChainHandlerB extends ChainHandler{
        @Override
        protected void handleProcess() {
            System.out.println("B");

        }
    }

    static class ChainHandlerC extends ChainHandler{
        @Override
        protected void handleProcess() {
            System.out.println("C");

        }
    }

    public static void main(String[] args) {
        List<ChainHandler> handlers = Arrays.asList(new ChainHandlerA(),new ChainHandlerB(),new ChainHandlerC());
        Chain chain = new Chain(handlers);
        chain.proceed();
    }
}
