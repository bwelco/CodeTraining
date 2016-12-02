package Train;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by bwelco on 2016/12/1.
 */
public class Day5_01_SamSungTest {

    public void getPath(int[] E1, int[] E2){

        int[][] relation = new int[E1.length + 1][E1.length + 1];
        int[] length = new int[E1.length + 1];
        for (int i = 0 ; i < length.length; i++) length[i] = 0;

        for (int i = 0; i < E1.length; i++) {
            int index = E1[i];
            int l = length[index];
            length[index] += 1;
            relation[index][l] = E2[i];
        }

        for (int i = 0; i < E2.length; i++) {
            int index = E2[i];
            int l = length[index];
            length[index] += 1;
            relation[index][l] = E1[i];
        }

        //print_two(relation);

        boolean[] visit = new boolean[E1.length + 1];
        boolean[] color = new boolean[E1.length + 1];

        // false 代表白色，true代表黑色
        for (int i = 0; i < color.length; i++) color[i] = false;

        visit[1] = true;
        color[1] = true;

        if (canGet(E1.length - 1, 1, relation, length, visit, false, color)) {
            System.out.println("can!");
        } else {
            System.out.println("can not!");
        }

    }

    public boolean canGet(int remain,int start, int[][] relation, int[] relation_length, boolean[] visit, boolean toPaintColor, boolean[] color){
        // 是定点！

        if (remain == 0) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            int num = 0;
            System.out.print("**** ");
            for (int i = 1; i < color.length; i++) if (color[i]) {num++;System.out.print(i + " ");}
            System.out.println(" ****");
            return true;
        } else {

            boolean canOver = false;
            for (int i = 0; i < relation_length[start]; i++) {
                int next = relation[start][i];

                // 看下一个会不会冲突
                boolean canChoose = true;
                for (int j = 0; j < relation_length[next]; j++) {
                    int next_next = relation[next][j];
                    // 访问过 并且颜色和当前要涂色的一样
                    if (visit[next_next] && color[next_next] == toPaintColor) {
                        canChoose = false;
                        break;
                    }
                }

                if (canChoose) {
                    // 涂色
                    boolean tempColor = color[next];
                    color[next] = toPaintColor;
                    visit[next] = true;
                    // 递归，如果能访问，找到路径。退出
                    if (canGet(remain - 1, next, relation, relation_length, visit, !toPaintColor, color)) {
                        canOver = true;
                        break;
                    } else {
                        // 不行的话，返回，清除状态
//                        color[next] = tempColor;
//                        visit[next] = false;
                        return false;
                    }
                }
            }

            if (canOver) {
                return true;
            } else {
                return false;
            }

        }
    }

    public void print_two(int[][] relation){
        for (int i = 0; i < relation.length; i++) {
            for (int j = 0; j < relation[0].length; j++) {
                System.out.print(relation[i][j] + " ");
            }
            System.out.println();
        }
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

            Day5_01_SamSungTest samSungTest = new Day5_01_SamSungTest();
            samSungTest.getPath(E1, E2);
        }
    }
}
