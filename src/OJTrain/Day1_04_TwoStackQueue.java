package OJTrain;

import java.util.Stack;

/**
 * Created by bwelco on 2016/11/27.
 */

/*用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。*/
public class Day1_04_TwoStackQueue {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        int a;
        if (stack2.empty()) {
            while (!stack1.empty()) {
                a = stack1.peek();
                stack2.push(a);
                stack1.pop();
            }
        }
        a = stack2.peek();
        stack2.pop();
        return a;
    }

    public static void main(String[] args) {

    }
}
