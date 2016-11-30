package Train;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by bwelco on 2016/11/27.
 */
public class Day1_02_PrintNodeList {
/*输入一个链表，从尾到头打印链表每个节点的值。
*/

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode ReverseList(ListNode head) {
        ListNode p = head;
        Stack<Integer> stack = new Stack<>();

        while (p != null) {
            stack.push(p.val);
            p = p.next;
        }

        p = head;
        while (p != null) {
            p.val = stack.pop();
            p = p.next;
        }
        return head;
    }

    public ListNode FindKthToTail(ListNode head, int k) {
        int length = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            length++;
        }

        int temp = length - k;
        p = head;
        while (length-- != 0) {
            p = p.next;
        }
        return p;
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        if (listNode == null) return arrayList;
        get(arrayList, listNode);
        return arrayList;
    }

    public void get(ArrayList<Integer> arrayList, ListNode listNode) {
        if (listNode.next != null) {
            get(arrayList, listNode.next);
        }

        arrayList.add(listNode.val);

    }


    public static void main(String[] args) {

    }
}
