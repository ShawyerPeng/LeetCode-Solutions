package aaa;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] nums = new int[10000][10000];
        int N = 0;
        int row = 0, col = 0;
        while (in.hasNextLine()) {
            String s = in.nextLine();
            if (s == null || s.length() == 0) break;
            s = s.replace(" ", "");
            char[] chs = s.toCharArray();
            for (col = 0; col < chs.length; col++) {
                nums[row][col] = chs[col] - '0';
                if (row == 0) N++;
            }
            if (row == chs.length - 1) break;
            row++;
        }

        int[][] temp = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                temp[i][j] = nums[N - j - 1][i];
            }
        }

        for (int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < N; j++) {
                sb.append(temp[i][j]).append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);
            if (i != N - 1) System.out.println(sb);
            else System.out.print(sb);
        }
    }
}
