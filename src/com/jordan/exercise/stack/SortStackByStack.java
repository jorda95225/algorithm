package com.jordan.exercise.stack;

import java.util.Stack;

/**
 * @autheor masheng
 * @description 用一个栈实现另一个栈的排序
 * @date 2020/4/20
 */
public class SortStackByStack {
    //一个栈中元素的类型为整型，现在想将该栈从顶到底按从大到小的顺序排序，只许申请一个栈。除此之外，
    // 可以申请新的变量，但不能申请额外的数据结构。如何完成排序？
    public void sortStackByStack(Stack<Integer> stack) {
        Stack<Integer> helpStack = new Stack<>();
        while (!stack.isEmpty()) {
            //弹出栈顶元素
            int i = stack.pop();
            //如果i小于help的栈顶元素，直接压入
            //如果i大于help的栈顶元素，将help的元素弹出，直到help的栈顶元素大于等于i
            while (!helpStack.isEmpty() && i > helpStack.peek()) {
                stack.push(helpStack.pop());
            }
            helpStack.push(i);
        }
        //最后将help中的所有元素压入stack
        while (!helpStack.isEmpty()) {
            stack.push(helpStack.pop());
        }
    }

    public static void main(String[] args) {
        SortStackByStack sortStackByStack = new SortStackByStack();
        Stack<Integer> stack = new Stack<>();
        stack.add(2);
        stack.add(1);
        stack.add(4);
        stack.add(-9);
        stack.add(2);
        stack.add(0);
        sortStackByStack.sortStackByStack(stack);
        for (Integer i : stack) {
            System.out.println(i);
        }
    }
}