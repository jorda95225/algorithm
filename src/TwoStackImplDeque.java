import java.util.Stack;

/**
 * @autheor masheng
 * @description 两个栈实现队列
 * @date 2020/4/16
 */
//用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
public class TwoStackImplDeque {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        //插入时，直接插入stack1
        stack1.push(node);
    }

    public int pop() {
        //弹出时，当stack2不为空的时候，弹出stack2栈顶元素，如果stack2为空，将stack1逐个出栈
        // 入栈stack2，然后再弹出stack2栈顶元素
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}