package OJTrain;

/**
 * Created by bwelco on 2016/11/29.
 */
public class Day3_03_IsInterleave {


    /*
        Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
        For example,
        Given:
        s1 ="aabcc",
        s2 ="dbbca",
        When s3 ="aadbbcbcac", return true.
        When s3 ="aadbbbaccc", return false.
    */

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() == 0 && s2.length() == 0 && s3.length() == 0) return true;
        if (s3 == null || s3.length() == 0) return false;
        if (s1.length() + s2.length() != s3.length()) return false;

        if (s3.length() == 1) {
            if (s3.equals(s1) || s3.equals(s2)) {
                return true;
            } else {
                return false;
            }
        }

        return isInterleave(s1, s2, s3, 0, 0, 0);
    }

    public boolean isInterleave(String s1, String s2, String s3, int start1, int start2, int start3) {

        if (start1 < s1.length() && start2 < s2.length()) {
            if (s3.charAt(start3) == s1.charAt(start1)) {
                if (s3.charAt(start3) == s2.charAt(start2)) {
                    return isInterleave(s1, s2, s3, start1 + 1, start2, start3 + 1) ||
                            isInterleave(s1, s2, s3, start1, start2 + 1, start3 + 1);
                } else
                    return isInterleave(s1, s2, s3, start1 + 1, start2, start3 + 1);
            } else if (s3.charAt(start3) == s2.charAt(start2)) {
                if (s3.charAt(start3) == s1.charAt(start1)) {
                    return isInterleave(s1, s2, s3, start1 + 1, start2, start3 + 1) ||
                            isInterleave(s1, s2, s3, start1, start2 + 1, start3 + 1);
                } else
                    return isInterleave(s1, s2, s3, start1, start2 + 1, start3 + 1);
            } else return false;
        } else if (start1 == s1.length() && start2 < s2.length()) {
            if (s3.charAt(start3) == s2.charAt(start2)) {
                return isInterleave(s1, s2, s3, start1, start2 + 1, start3 + 1);
            } else return false;
        } else if (start1 < s1.length() && start2 == s2.length()) {
            if (s3.charAt(start3) == s1.charAt(start1)) {
                return isInterleave(s1, s2, s3, start1 + 1, start2, start3 + 1);
            } else return false;
        } else {
            if (start3 < s3.length()) {
                return false;
            } else {
                return true;
            }
        }

    }


    public static void main(String[] args) {
        Day3_03_IsInterleave isInterleave = new Day3_03_IsInterleave();
        System.out.print(isInterleave.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }
}
