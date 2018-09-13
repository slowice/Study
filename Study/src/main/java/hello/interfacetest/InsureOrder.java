package hello.interfacetest;

public class InsureOrder implements Order{
    @Override
    public void getOrder() {
        System.out.println("this is InsureOrder");
    }
}
