package OJTrain;

import java.util.ArrayList;

/**
 * Created by bwelco on 2016/11/29.
 */
public class Day3_01_MinimumTotal {

    /*
    Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
    For example, given the following triangle
    [
         [2],
        [3,4],
       [6,5,7],
      [4,1,8,3]
    ]

    The minimum path sum from top to bottom is11(i.e., 2 + 3 + 5 + 1 = 11).
    Note:
    Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
    */
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        return getMin(triangle, 0, 0);
    }

    public int getMin(ArrayList<ArrayList<Integer>> triangle, int start_hang, int start_index){
        if (start_hang == triangle.size()) {
            return 0;
        }

        int num = triangle.get(start_hang).get(start_index);
        int below1 = num + getMin(triangle, start_hang + 1, start_index);
        int below2 = num + getMin(triangle, start_hang + 1, start_index + 1);

        if (below1 < below2)
            return below1;
        else
            return below2;
    }

    public static void main(String[] args) {

    }
}
