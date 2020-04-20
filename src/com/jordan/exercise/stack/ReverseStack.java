package com.jordan.exercise.stack;

import java.util.Stack;

/**
 * @autheor masheng
 * @description 仅用递归函数和栈操作逆序一个栈
 * @date 2020/4/20
 */
public class ReverseStack {
    //一个栈依次压入1、2、3、4、5，那么从栈顶到栈底分别为5、4、3、2、1。将这个栈转置后，从栈顶到栈
    // 底为 1、2、3、4、5，也就是实现栈中元素的逆序，但是只能用递归函数来实现，不能用其他数据结构。
    //递归函数一：将栈底元素返回并移除
    public int getRemoveLastRemove(Stack<Integer> stack){
        int result = stack.pop();
        //递归终止条件
        if (stack.isEmpty()){
            //返回栈底元素
            return result;
        }else{
            int last = getRemoveLastRemove(stack);
            //将其他元素重新压入
            stack.push(result);
            return last;
        }
    }

    //逆序栈
    public void reverse(Stack<Integer> stack){
        //递归终止条件
        if (stack.isEmpty()){
            return;
        }
        //递归调用返回栈底，返回1,2,3，然后再调用，逆序压入
        int i = getRemoveLastRemove(stack);
        reverse(stack);
        stack.push(i);
    }

    public static void main(String[] args) {
        ReverseStack reverseStack = new ReverseStack();
        Stack<Integer> stack = new Stack<>();
        stack.add(2);
        stack.add(1);
        stack.add(4);
        stack.add(-9);
        stack.add(2);
        stack.add(0);
        reverseStack.reverse(stack);
        for (Integer i : stack) {
            System.out.println(i);
        }
    }
}