/**
 * @autheor masheng
 * @description 斐波那契数列
 * @date 2020/4/16
 */
//写一个函数，输入n，求斐波那契（Fibonacci）数列的第n项。
public class Fibonacci {
    public int Fibonacci(int n) {
        //1.递归法
//        if (n == 0) {
//            return 0;
//        }
//        if (n == 1) {
//            return 1;
//        }
//        return Fibonacci(n - 1) + Fibonacci(n - 2);
        //2.优化递归
//        int result[] = new int[40];
//        result[0] = 0;
//        result[1] = 1;
//        for (int i = 2; i <= n; i++) {
//            result[i] = result[i - 1] + result[i - 2];
//        }
//        return result[n];
        //3.优化存储，每次其实用到了最近的2个数，只存储这两个
        if (n == 0){
            return 0;
        }else if (n== 1){
            return 1;
        }
        int sum = 0;
        //n - 2
        int two = 0;
        //n - 1
        int one = 1;
        for (int i = 2; i <= n; i++) {
            sum = one + two;
            two = one;
            one = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        long start = System.currentTimeMillis();
        System.out.println(fibonacci.Fibonacci(39));
        long end = System.currentTimeMillis();
        System.out.println("总共耗费时间为：" + (end - start) * 1000);
    }
}