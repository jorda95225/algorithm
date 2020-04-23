package com.jordan.exercise.stack;

/**
 * @autheor masheng
 * @description 递归解决汉诺塔问题
 * @date 2020/4/22
 */
//汉诺塔问题比较经典，这里修改一下游戏规则：现在限制不能从最左侧的塔直接移动到最右侧，也不能从最右侧直接移动到最左侧，而是
// 必须经过中间。求当塔有N层的时候，打印最优移动过程和最优移动总步数。
public class HanoProblem1 {
    public int hanoProblem(int num, String left, String mid, String right) {
        if (num < 1) {
            return 0;
        }
        return process(num, left, mid, right, left, right);
    }

    public int process(int num, String left, String mid, String right, String from, String to) {
        //如果只剩一层
        if (num == 1) {
            //左-中，中-左，中-右，右-中
            if (from.equals("mid") || to.equals("mid")) {
                System.out.println("Move 1 from " + from + " to " + to);
                return 1;
            } else {
                System.out.println("Move 1 from " + from + " to " + mid);
                System.out.println("Move 1 from " + mid + " to " + to);
                return 2;
            }
        }
        //剩下N层
        //左-中，中-左，中-右，右-中
        if (left.equals("mid") || right.equals("mid")) {
            String another = (from.equals(left) || to.equals(left)) ? right : left;
            int part1 = process(num - 1, left, mid, right, from, another);
            int part2 = 1;
            System.out.println("Move "+ num + " from " + from + " to " + to);
            int part3 = process(num - 1, left, mid, right, another, to);
            return part1 + part2 + part3;
        }else{
            int part1 = process(num - 1,left,mid,right,from,to);
            int part2 = 1;
            System.out.println("Move "+ num + " from " + from + " to " + mid);
            int part3 = process(num - 1,left,mid,right,to,from);
            int part4 = 1;
            System.out.println("Move "+ num + " from " + mid + " to " + to);
            int part5 = process(num - 1,left,mid,right,from,to);
            return part1 + part2 + part3 +part4 + part5;
        }
    }

    public static void main(String[] args) {
        HanoProblem1 hanoProblem1 = new HanoProblem1();
        System.out.println(hanoProblem1.hanoProblem(3,"left","mid","right"));
    }
}