package Train;

/**
 * Created by bwelco on 2016/11/28.
 */

/*HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,
当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,
并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8
(从第0个开始,到第3个为止)。你会不会被他忽悠住？(子向量的长度至少是1)*/

public class Day2_04_FindGreatestSumOfSubArray {

    public int FindGreatestSumOfSubArray(int[] array) {

        if (array == null || array.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {

            for (int j = i+1; j < array.length; j++) {
                int v = getV(i, j, array);
                if (max < v) {
                    max = v;
                }
            }
        }

        return max;
    }

    public int getV(int start ,int end , int[] array){
        int v = 0;
        for (int i = start; i <= end; i++) {
            v += array[i];
        }
        return v;
    }

    public static void main(String[] args) {
        Day2_04_FindGreatestSumOfSubArray findGreatestSumOfSubArray = new Day2_04_FindGreatestSumOfSubArray();
        System.out.print(findGreatestSumOfSubArray.FindGreatestSumOfSubArray(new int[]{6,-3,-2,7,-15,1,2,2}));
    }
}
