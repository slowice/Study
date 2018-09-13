package hello.abs_interface;

public class TestUtils implements MehtodHelper,ClassHelper{

    @Override
    public String getClassName() {
        return Thread.currentThread().getStackTrace()[2].getFileName();
    }

    @Override
    public String getMethodName() {
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }

}