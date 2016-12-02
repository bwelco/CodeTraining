package OJTrain;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by bwelco on 2016/11/28.
 */
public class Day2_02_MoreThanHalfNum {

/*数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。*/


    public int MoreThanHalfNum_Solution(int [] array) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (hashMap.containsKey(array[i])) {
                hashMap.put(array[i], hashMap.get(array[i]) + 1);
            } else {
                hashMap.put(array[i], 1);
            }
        }

        int max = 0;
        int key = 0;

        Iterator iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = (Map.Entry<Integer, Integer>) iterator.next();
            if (max < entry.getValue()) {
                max = entry.getValue();
                key = entry.getKey();
            }
        }


        System.out.println("max = " + max);

        if (max > array.length / 2) {
            return key;
        } else {
            return 0;
        }

    }

    public static void main(String[] args) {
        Day2_02_MoreThanHalfNum moreThanHalfNum = new Day2_02_MoreThanHalfNum();
        System.out.print(moreThanHalfNum.MoreThanHalfNum_Solution(new int[]{1,1,1,2,2,2,2,2,2,2,2,2,2,1,3}));
    }
}
