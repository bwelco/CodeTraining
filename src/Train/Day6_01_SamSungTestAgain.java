package Train;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by bwelco on 2016/12/2.
 */
public class Day6_01_SamSungTestAgain {

    public void getPath(int[] E1, int[] E2){

    }

    public static void main(String[] args) {
        try {
            System.setIn(new FileInputStream("Input/Test.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);
        int test_case = scanner.nextInt();


        for (int t = 0; t < test_case; t++) {
            int V = scanner.nextInt();
            int E = scanner.nextInt();
            int[] E1 = new int[V];
            int[] E2 = new int[V];

            for (int i = 0; i < E; i++) {
                E1[i] = scanner.nextInt();
                E2[i] = scanner.nextInt();
            }

            Day6_01_SamSungTestAgain samSungTest = new Day6_01_SamSungTestAgain();
            samSungTest.getPath(E1, E2);
        }
    }
}
