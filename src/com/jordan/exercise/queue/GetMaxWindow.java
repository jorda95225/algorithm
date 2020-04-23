package com.jordan.exercise.queue;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @autheor masheng
 * @description 生成窗口最大值数组
 * @date 2020/4/22
 */
public class GetMaxWindow {
    public int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<>();
        int[] result = new int[arr.length - w + 1];
        int index = 0;
        //队首大值，队尾小值
        for (int i = 0; i < arr.length; i++) {
            //如果队列不为空,并且队尾的元素不大于arr[i],一直弹出
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
                qmax.pollLast();
            }
            //给队尾增加
            qmax.addLast(i);
            //如果qmax队头的下标等于i-w，说明当前qmax队头的下标已过期，弹出当前对头的下标即可。
            if (qmax.peekFirst() == i - w) {
                qmax.pollFirst();
            }
            if (i >= w - 1) {
                result[index++] = arr[qmax.peekFirst()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        GetMaxWindow getMaxWindow = new GetMaxWindow();
        int[] arr = {4,3,5,4,3,3,6,7};
        int[] result = getMaxWindow.getMaxWindow(arr, 3);
        for (int i : result) {
            System.out.println(i);
        }
    }
}