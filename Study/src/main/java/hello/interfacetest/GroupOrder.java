package hello.interfacetest;

public class GroupOrder implements Order{
    @Override
    public void getOrder() {
        System.out.println("this is GroupOrder");
    }
    public void fly(){
        System.out.println("fly");
    }
}
