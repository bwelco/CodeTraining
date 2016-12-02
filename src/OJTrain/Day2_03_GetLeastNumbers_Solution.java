package OJTrain;

import java.util.ArrayList;

/**
 * Created by bwelco on 2016/11/28.
 */
public class Day2_03_GetLeastNumbers_Solution {

    /*输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。*/

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        fastSort(0, input.length - 1, input);

        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 0 ; i < k; i++) {
            arrayList.add(input[i]);
        }

        return arrayList;
    }

    public void fastSort(int left, int right, int array[]){

        if (left >= right) {
            return;
        }

        int toCompare = array[left];
        int i = left;
        int j = right;

        while (i < j) {
            while (i < j && array[j] >= toCompare) {
                j--;
            }

            while (i < j && array[i] <= toCompare) {
                i++;
            }

            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

        array[left] = array[i];
        array[i] = toCompare;

        fastSort(left, i - 1, array);
        fastSort(i+1, right, array);
    }

    public static void main(String[] args) {

    }
}
