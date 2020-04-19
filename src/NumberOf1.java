/**
 * @autheor masheng
 * @description 二进制中1的个数
 * @date 2020/4/17
 */
//题目：请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。例如把9表示成二进制
// 是1001，有2位是1。因此如果输入9，该函数输出2。
public class NumberOf1 {
    public int NumberOf1(int n) {
        //分析：每次判断最右边的一位是不是1，判断方法是和1做与运算，结果是1证明最右边一位就是1，用
        // 运算符效率比除以2高很多，但是这种情况输入一个负数的话，要保证移位后仍然是个负数，移位后最
        // 高位会设为1，会陷入死循环，所以可以改为将1左移，每次去判断
        //1.第一种方法，循环次数等于二进制位数
//        int count = 0;
//        int flag = 1;
//        while (flag != 0){
//            //如果与不等于0，则证明这位是1
//            if ((n & flag) != 0){
//                count++;
//            }
//            //将1左移
//            flag <<= 1;
//        }
//        return count;
        //2.方法二：如果一个数不等于0，则至少有一位是1，减去1后最后是1的那位之后的所有0都变成1，
        // 前面的保持不变，将这两个做与运算，相当于把最右边的1变成0，所以一个整数的二进制有多少个1，
        // 就进行多少次这样的操作
        int count = 0;
        while (n != 0) {
            count++;
            n = (n - 1) & n;
        }
        return count;
    }
}