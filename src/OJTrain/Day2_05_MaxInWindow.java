package OJTrain;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by bwelco on 2016/11/28.
 */
public class Day2_05_MaxInWindow {

    /*给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
    例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
    那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
    针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
    {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
     {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。*/

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>();
        int max_index = 0;

        if (size == 0 || size > num.length) return arrayList;

        int max = num[0];
        for (int i = 0; i < size; i++) {
            queue.add(num[i]);
            if (max < num[i]) {
                max_index = i;
                max = num[i];
            }
        }

        arrayList.add(max);

        for (int i = size; i < num.length; i++) {
            queue.poll();
            queue.add(num[i]);

            if (num[i] > arrayList.get(arrayList.size() - 1)) {
                max_index = size - 1;
                arrayList.add(num[i]);

            } else {
                if (max_index == 0) {

                    int maxa = Integer.MIN_VALUE;
                    int maxa_index = 0;
                    int l = 0;
                    for (Integer integer : queue) {
                        if (maxa < integer) {
                            max_index = l;
                            maxa = integer;
                        }
                        l++;
                    }

                    max_index = maxa_index;
                    arrayList.add(maxa);
                } else {
                    max_index--;
                    arrayList.add(arrayList.get(arrayList.size() - 1));
                }
            }
        }

        return arrayList;
    }


    public static void main(String[] args) {
        Day2_05_MaxInWindow maxInWindow = new Day2_05_MaxInWindow();
        System.out.print(maxInWindow.maxInWindows(new int[]{2, 3, 4, 2, 6, 2, 5, 1}, 3));
    }
}
