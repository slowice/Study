package hello.chain.normal;

public abstract class Handler {
    private Handler processor;

    public Handler getProcessor() {
        return processor;
    }

    public void setProcessor(Handler processor) {
        this.processor = processor;
    }

    public void excute(){
        handleProcess();
        if(processor!=null){
            processor.excute();
        }
    }

    protected abstract void handleProcess();
}
