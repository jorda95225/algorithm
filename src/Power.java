/**
 * @autheor masheng
 * @description 数值的整数次方
 * @date 2020/4/17
 */
//给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
//保证base和exponent不同时为0
public class Power {
    public double Power(double base, int exponent) {
        //1.如果幂为0，并且base不为0
        if (exponent == 0 && base != 0){
            return 1;
        }
        //2.如果幂为1
        if (exponent == 1){
            return base;
        }
        //3.如果base为0且幂大于0
        if (base==0&&exponent>0){
            return 0;
        }
        //4.如果base为0且幂小于0
        if (base==0&&exponent<0){
            throw new RuntimeException("分母不能为0");
        }
        int n = exponent;
        if (exponent < 0){
            n = -exponent;
        }
        double result = Power(base,n>>1);
        result*=result;
        //奇数
        if ((n&1)==1){
            result*=base;
        }
        //如果幂小于0
        if (exponent < 0){
            result = 1/result;
        }
        return result;
    }
}