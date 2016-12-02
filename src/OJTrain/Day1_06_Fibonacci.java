package OJTrain;

/**
 * Created by bwelco on 2016/11/27.
 */

/*大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。*/
public class Day1_06_Fibonacci {

    public int Fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 1;

        int temp = 2;
        int one = 1, two = 1;

        for (int i = 3; i <= n; i++) {
            temp = one + two;
            one = two;
            two = temp;
        }

        return temp;
    }

    public static void main(String[] args) {
        Day1_06_Fibonacci fibonacci = new Day1_06_Fibonacci();
        System.out.print(fibonacci.Fibonacci(10));

    }
}
