package com.jordan.exercise.stack;

import java.util.Stack;

/**
 * @autheor masheng
 * @description 最小栈
 * @date 2020/4/20
 */
public class MinStack {
    //实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作。
    //1.pop、push、getMin操作的时间复杂度都是O（1）。
    //2.设计的栈类型可以使用现成的栈结构。
    //结论：方案一在压入时省空间，但弹出时费时间，方案二压入时费空间，但弹出时省时间
    //方案一：用一个数据栈和一个最小栈
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MinStack() {
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }

    //push，往stackData压入，判断stackMin是否为空，如果为空也压入，不为空则比较栈顶元素和压入的值的
    // 大小，栈顶元素大则压入
    public void push1(int newNum) {
        this.stackData.push(newNum);
        if (stackMin.isEmpty()) {
            this.stackMin.push(newNum);
        } else if (this.stackMin.peek() >= newNum) {
            this.stackMin.push(newNum);
        }
    }

    //方案二
    public void push2(int newNum) {
        this.stackData.push(newNum);
        //判断stackMin是否为空，如果为空也压入，不为空则比较栈顶元素和压入的值的
        //大小，栈顶元素大则压入，栈顶元素小则复制一份栈顶元素
        if (stackMin.isEmpty()) {
            this.stackMin.push(newNum);
        } else if (this.stackMin.peek() >= newNum) {
            this.stackMin.push(newNum);
        } else {
            this.stackMin.push(this.stackMin.peek());
        }
    }

    //pop
    public int pop1() {
        //先判断stackData是否为空
        if (this.stackData.isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        //不为空则弹出stackData栈顶值，该值只会大于等于stackMin的栈顶值，如果等于则弹出
        // stackMin栈顶，否则弹出value
        int value = this.stackData.pop();
        if (value == this.stackMin.peek()) {
            this.stackMin.pop();
        }
        return value;
    }

    //方案二
    public int pop2() {
        //先判断stackData是否为空
        if (this.stackData.isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        //不为空则弹出stackData栈顶值，弹出stackMin栈顶
        this.stackMin.pop();
        return this.stackData.pop();
    }

    public int getMin() {
        if (this.stackMin.isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        return this.stackMin.peek();
    }
}