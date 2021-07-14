import java.util.Scanner;

public class ZeroOne {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 物品个数
        int N = in.nextInt();
        // 背包容量
        int V = in.nextInt();
        // 背包信息，体积和价值
        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++){
            arr[i][0] = in.nextInt();
            arr[i][1] = in.nextInt();
        }

        in.close();

        int value = new ZeroOne().solve(N, V, arr);
        System.out.println(value);
    }

    // 01背包解法
    public int solve(int N, int V, int[][] arr){
        int[][] value = new int[N + 1][V + 1];

        int thisValue;
        for (int i = 1; i < N + 1; i++){
            for (int j = 1; j < V + 1; j++){
                thisValue = arr[i - 1][0];
                if (j - thisValue < 0){
                    value[i][j] = value[i - 1][j];
                }
                else {
                    value[i][j] = Math.max(value[i - 1][j], value[i - 1][j - thisValue] + arr[i - 1][1]);
                }

            }
        }

        return value[N][V];
    }
}
