package com.jordan.exercise.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @autheor masheng
 * @description 单调栈结构求数组左右的最小值
 * @date 2020/4/23
 */
public class GetNearLessNoRepeat {
    //给定一个不含有重复值的数组arr，找到每一个i位置左边和右边离i位置最近且值比arr[i]小的位置。返回所有位置
    // 相应的信息(二维数组)。
    public int[][] getNearLessNoRepeat(int[] arr){
        int[][] res = new int[arr.length][2];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            //当栈不为空并且遍历到的元素小于栈顶位置的元素时，弹出栈顶元素
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]){
                Integer popIndex = stack.pop();
                //判断栈是否为空
                int leftLessIndex = stack.isEmpty()? -1 : stack.peek();
                //左边为栈中的下一个元素，右边为当前遍历到的位置
                res[popIndex][0] = leftLessIndex;
                res[popIndex][1] = i;
            }
            //将i压入栈中
            stack.push(i);
        }
        //遍历完成以后，弹出栈中剩下的位置
        while (!stack.isEmpty()){
            int popIndex = stack.pop();
            int leftLessIndex = stack.isEmpty()? -1 : stack.peek();
            res[popIndex][0] = leftLessIndex;
            res[popIndex][1] = -1;
        }
        return res;
    }

    public static void main(String[] args) {
        GetNearLessNoRepeat repeat = new GetNearLessNoRepeat();
        int[] arr = {3,4,1,5,6,2,7};
        int[][] res = repeat.getNearLessNoRepeat(arr);
        System.out.println(Arrays.deepToString(res));
    }
}