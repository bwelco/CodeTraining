package Train;

/**
 * Created by bwelco on 2016/11/30.
 */
public class Day4_01_MinCut {

    /*
          Given a string s, partition s such that every substring of the partition is a palindrome.
          Return the minimum cuts needed for a palindrome partitioning of s.
          For example, given s ="aab",
          Return1since the palindrome partitioning["aa","b"]could be produced using 1 cut.
           
          analysis:
          定义状态数组: minCuts[n], minCuts[j]表示从0到j(包含j)的子串所需要用到的最小的切割次数
          状态转移方程: 当子串str[i...j]是一个回文子串时, minCuts[j] = min(minCuts[i-1] + 1, minCuts[i])
           
          注意的是:
           
          1. 此时如果i = 0, 则表示当前的str[0...j]不需要切割，即: minCuts[j] = 0;
          2. 初始化和计算每一项之前都默认minCuts[j] = minCuts[j-1] + 1, 其中的原因自己分析吧;
          3. 当检测到目前str[0...j]是回文的时候, 需要再一次把minCuts[j] = 0;
   
  */
    public int minCut(String s) {
        int[][] min = new int[s.length()][s.length()];
        boolean[][] v = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                min[i][j] = 0;
                v[i][j] = false;
            }
        }

        char[] arr = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i);
        }

        return minCut(0, s.length() - 1, min, v, arr);
    }


    public int minCut(int start, int end, int[][] min, boolean[][] v, char[] s) {

        if (start == end) return 0;
        if (start == end - 1) {
            if (s[start] == s[end])
                return 0;
            else return 1;
        }

        // 访问过之后，区间最小值返回
        if (v[start][end]) {
            return min[start][end];
        } else {
            // 没访问，先判断这个区间是不是回文，是返回0，否继续分解区间
            if (isPal(s, start, end)) {
                min[start][end] = 0;
                v[start][end] = true;
                return 0;
            }
        }

        int temp_min = Integer.MAX_VALUE;

        for (int i = start + 1; i <= end - 1; i++) {

            int left = minCut(start, i, min, v, s);
            //System.out.println("left = " + left+ " start = " + start + " i = " + i);
            int right = minCut(i + 1, end, min, v, s);

            int value = left + right + 1;
            if (temp_min > value) {
                // System.out.println("v = " + value);
                temp_min = value;
            }
        }
        return temp_min;
    }

    public boolean isPal(char[] s, int start, int end) {
        while (start <= end) {
            if (s[start] != s[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        Day4_01_MinCut minCut = new Day4_01_MinCut();
        System.out.print(minCut.minCut("adminadminadminadminadminadmin"));
    }
}
