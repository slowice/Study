package hello.chain.good;

public abstract class ChainHandler {
    public void excute(Chain chain){
        handleProcess();
        chain.proceed();
    }
    protected abstract void handleProcess();
}
