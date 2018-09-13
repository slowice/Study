package hello.math;

public class Test {
    public void sinx(){
        //y为列方向，值从1到-1，步长为0.1
        for (double y = 1;y>=-1;y-=0.01) {
            //计算出y对应的弧度，乘10为图形放大倍数
            int m = -(int) (Math.asin(y) * 10);
            if (y > 0) {
                for (int x = 1; x < 1 - m; x++) {
                    System.out.print(" ");
                }
                System.out.print("*");
                //31为10*π的整数部分，打印出来的曲线比较顺眼
                for (int x = 1; x < 31 + 2 * m; x++) {
                    System.out.print(" ");
                }
                System.out.println("*");
            }
            if (y <= 0) {
                for (int x = 1; x < 32 + m; x++) {
                    System.out.print(" ");
                }
                System.out.print("*");
                //31为10*π的整数部分，打印出来的曲线比较顺眼
                for (int x = 1; x < 31 - 2 * m; x++) {
                    System.out.print(" ");
                }
                System.out.println("*");
            }
        }
    }

    public static void main(String[] args) {
        /*for(double y=1;y>=-1;y-=0.1){
            System.out.println(y);
        }*/
        System.out.println(Math.asin(0));
    }


}
