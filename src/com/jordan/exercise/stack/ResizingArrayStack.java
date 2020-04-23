package com.jordan.exercise.stack;

import java.util.Iterator;

/**
 * @autheor masheng
 * @description 下压栈（能够动态调整数组大小的实现）
 * @date 2020/4/23
 */
public class ResizingArrayStack<Item> {
    //声明一个初始容量为1的数组
    private Item[] a = (Item[]) new Object[1];
    //栈元素的数量
    private int N = 0;

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    //扩容
    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    //push
    public void push(Item item){
        if (N == a.length){
            resize(a.length * 2);
        }
        a[N++] = item;
    }

    public Item pop(){
        Item item = a[--N];
        a[N] = null;//避免对象游离
        //如果数组过长，缩小为原来的一半
        if (N > 0 && N == a.length / 4){
            resize(a.length / 2);
        }
        return item;
    }

    public Iterator<Item> iterator(){
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        private int i = N;
        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return a[--i];
        }

        @Override
        public void remove() {

        }
    }
}