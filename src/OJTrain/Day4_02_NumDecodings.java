package OJTrain;

/**
 * Created by bwelco on 2016/11/30.
 */
public class Day4_02_NumDecodings {

    /*
        A message containing letters fromA-Zis being encoded to numbers using the following mapping:
        'A' -> 1
        'B' -> 2
        ...
        'Z' -> 26
        Given an encoded message containing digits, determine the total number of ways to decode it.
        For example,
        Given encoded message"12", it could be decoded as"AB"(1 2) or"L"(12).
        The number of ways decoding"12"is 2.
    */

    public int numDecodings(String s) {
        if (s.length() == 0 || s.startsWith("0"))
            return 0;
        int len = s.length() + 1;
        int[] dp = new int[len];
        dp[1] = 1;
        dp[0] = 1;
        for (int i = 2; i < len; i++) {
            int t = Integer.valueOf(s.substring(i - 2, i));
            if (10 <= t && t <= 26) {
                dp[i] += dp[i - 2];
            }
            //注意0在这里要特殊对待
            int tmp = Integer.valueOf(s.substring(i - 1, i));
            if (1 <= tmp && tmp <= 9) {
                dp[i] += dp[i - 1];
            }
        }
        return dp[len - 1];
    }


//    public int numDecodings(char[] arr, int start, int[] v, boolean[] b) {
//        if (b[start]) return v[start];
//
//        if (arr[start] == '0') return 0;
//        if (start >= arr.length - 1) return 1;
//        if (start == arr.length - 2) {
//            if (arr[start] == '1' && (arr[start + 1] > '0' && arr[start + 1] <= '9')) {
//                return 2;
//            }
//            if (arr[start] == '1' && arr[start + 1] == '0') {
//                return 1;
//            }
//            if (arr[start] == '2' && arr[start + 1] == '0') {
//                return 1;
//            }
//            if (arr[start] == '2' && arr[start + 1] > '6') {
//                return 1;
//            }
//            if (arr[start] == '2' && arr[start + 1] <= '6' && arr[start + 1] >= '1') {
//                return 2;
//            }
//        }
//
//        if (arr[start] == '1') {
//            if (arr[start + 1] == '0') return numDecodings(arr, start + 2, v, b);
//            else {
//                int a1 = numDecodings(arr, start + 2, v, b);
//                int a2 = numDecodings(arr, start + 1, v, b);
//                v[start + 2] = a1;
//                b[start + 2] = true;
//                v[start + 1] = a2;
//                b[start + 1] = true;
//                return 1 + a1 + a2;
//            }
//        } else if (arr[start] == '2') {
//            if (arr[start + 1] == '0') {
//                int a = numDecodings(arr, start + 2, v, b);
//                v[start + 2] = a;
//                b[start + 2] = true;
//                return a;
//            } else if (arr[start + 1] > '0' && arr[start + 1] <= '6') {
//                int a1 = numDecodings(arr, start + 2, v, b);
//                int a2 = numDecodings(arr, start + 1, v, b);
//                v[start + 2] = a1;
//                b[start + 2] = true;
//                v[start + 1] = a2;
//                b[start + 1] = true;
//                return 1 + a1 + a2;
//            } else {
//                int a = numDecodings(arr, start + 1, v, b);
//                v[start + 1] = a;
//                b[start + 1] = true;
//                return a;
//            }
//        } else {
//            int a = numDecodings(arr, start + 1, v, b);
//            v[start + 1] = a;
//            b[start + 1] = true;
//            return a;
//        }
//    }

    public static void main(String[] args) {
        System.out.print(new Day4_02_NumDecodings().numDecodings("00"));
    }
}
