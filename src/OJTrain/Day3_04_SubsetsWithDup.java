package OJTrain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * Created by bwelco on 2016/11/29.
 */
public class Day3_04_SubsetsWithDup {

    /*
        Given a collection of integers that might contain duplicates, S, return all possible subsets.
        Note:
        Elements in a subset must be in non-descending order.
        The solution set must not contain duplicate subsets.

        For example,
        If S =[1,2,2], a solution is:
        [
          [2],
          [1],
          [1,2,2],
          [2,2],
          [1,2],
          []
        ]
    */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {

        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        ret.add(new ArrayList<Integer>());
        if (num == null || num.length == 0) {
            return ret;
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i : num) {
            arrayList.add(i);
        }

        Collections.sort(arrayList);
        for (int i = 0 ; i < num.length; i++) {
            num[i] = arrayList.get(i);
        }

        HashSet<ArrayList<Integer>> set = new HashSet<>();

        for (int i = 1; i <= num.length; i++) {
            insert(i, 0, num, i, 0, set);
        }

        for (ArrayList<Integer> a : set) {
            ret.add(a);
        }

        return ret;
    }

    public void insert(int remain, int start, int[] array, int length, int pre, HashSet<ArrayList<Integer>> set) {
        if (remain == 0) {
            ArrayList<Integer> a = new ArrayList<Integer>();
            for (int i = 0; i < length; i++) {
                a.add(array[i]);
            }
            set.add(a);

        } else {
            for (int i = start + pre; i < array.length; i++) {
                int temp = array[start];
                array[start] = array[i];
                array[i] = temp;

                insert(remain - 1, start + 1, array, length, pre, set);

                temp = array[start];
                array[start] = array[i];
                array[i] = temp;

                pre++;
            }
        }
    }


    public static void main(String[] args) {
        Day3_04_SubsetsWithDup subsetsWithDup = new Day3_04_SubsetsWithDup();
        System.out.print(subsetsWithDup.subsetsWithDup(new int[]{1,1}));
    }
}
