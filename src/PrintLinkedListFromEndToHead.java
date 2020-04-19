import java.util.ArrayList;
import java.util.Stack;

/**
 * @autheor masheng
 * @description 从尾到头打印链表
 * @date 2020/4/16
 */
//输入一个链表的头结点，从尾到头反过来打印出每个结点的值。
public class PrintLinkedListFromEndToHead {
    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        //分析：从头到尾输出比较简单，所以是否可以把连接节点的指针反转过来，但是会改变链表的结构
        //如果不能改变链表结构，首先要去遍历，从头到尾，后进先出，用栈
        Stack<Integer> stack = new Stack<>();
        //遍历链表
        while (listNode != null){
            //入栈
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        //输出结果用一个list保存
        ArrayList<Integer> list = new ArrayList<>();
        //当栈不为空
        while (!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }
}