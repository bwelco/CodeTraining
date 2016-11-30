package Train;

/**
 * Created by bwelco on 2016/11/27.
 */


/*
* 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
*/


public class Day1_05_FindMinInRotatedArray {

    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0 || array == null) return 0;

        int start = 0;
        int end = array.length - 1;

        int index = 0;
        while (start <= end-1) {
            int mid = (start + end) / 2;
            if (end - start == 1) {
                index = end;
                break;
            }

            if (array[mid] > array[start]) {
                start = mid;
            }

            if (array[mid] < array[end]){
                end = mid;
            }
        }

        return array[index];
    }


    public static void main(String[] args) {
        Day1_05_FindMinInRotatedArray findMinInRotatedArray = new Day1_05_FindMinInRotatedArray();
        System.out.print(findMinInRotatedArray.minNumberInRotateArray(new int[]{4, 5, 1, 2, 3}));
    }
}
