package Train;

/**
 * Created by bwelco on 2016/11/28.
 */
public class Day2_01_MultiNode {

    public static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode Clone(RandomListNode pHead) {

        if (pHead == null) {
            return null;
        }
        RandomListNode p = new RandomListNode(pHead.label);
        p.next = Clone(pHead.next);
        p.random = Clone(pHead.random);
        return p;
    }



    public static void main(String[] args) {

    }

}
