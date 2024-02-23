package study;
import java.util.Scanner;

public class Main {
    static int N, M;
    static int[] arr;
    static boolean[] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[M];
        visit = new boolean[N+1];
        permutation(0);
        sc.close();
    }

    static void permutation(int depth) {
        if (depth == M) {
            for (int val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = i;
                permutation(depth + 1);
                visit[i] = false;
            }
        }
    }
}
