package hello.exceptions;

public class ExceptionTest {

    public static void main(String[] args){

    }

    //ArrayIndexOutOfBoundsException
    private static void test2() {
        int[] arr = new int[2];
        Object o = arr[3];
        if (o instanceof ArrayIndexOutOfBoundsException) {
            System.out.println("出异常了");
        }
    }
}
