import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] enemies = new int[n];
        for (int i = 0; i < n; i++){
            enemies[i] = in.nextInt();
        }
        in.close();

        // 最多射几轮
        int cycle = (n + k) / (4 + k);

        List<Integer> res = new ArrayList<>(1);

        for (int i = 0; i < n - 4; i++){
            dfs(enemies, 0, 0, 4 * cycle, new ArrayList<>(), res);
        }

        System.out.println(res.remove(0));
    }

    public static void dfs(int[] enemies, int index, int count, int bullets, List<Integer> list, List<Integer> res){
        if (count > bullets || index >= enemies.length)
            return ;
        if (count % bullets == 0){
            int n = res.remove(0);
            int m = 0;
            for (Integer integer : list){
                m += integer;
            }
            res.add(Math.max(n, enemies[index] * 2 + m));
        }

        list.add(enemies[index]);
        for (int i = index + 1; i < enemies.length; i++){
            dfs(enemies, i, count++, bullets, list, res);
            list.remove(list.size() - 1);
        }
    }
}