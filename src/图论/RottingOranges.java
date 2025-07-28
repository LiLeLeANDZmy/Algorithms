package 图论;

import java.util.*;

public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int fresh = 0; // 新鲜橘子数量
        Queue<int[]> queue = new LinkedList<>();

        // 初始化：统计新鲜橘子 & 把腐烂橘子加入队列
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) fresh++;
                else if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        if (fresh == 0) return 0; // 没有新鲜橘子，直接返回 0

        int minutes = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}}; // 四个方向

        System.out.println("初始新鲜橘子数量: " + fresh);
        System.out.println("开始 BFS 模拟腐烂过程...");

        while (!queue.isEmpty()) {
            int size = queue.size();//本轮需要处理的腐烂橘子个数
            boolean rottedThisRound = false;//用于记录这一轮是否有橘子被腐烂

            for (int i = 0; i < size; i++) {   // 遍历所有腐烂的句子
                int[] cur = queue.poll();  // cur为腐烂橘子的坐标
                int x = cur[0], y = cur[1];  // 把当前腐烂橘子的坐标拆解
                for (int[] d : dirs) {  //遍历当前腐烂橘子的四个方向
                    int nx = x + d[0], ny = y + d[1];
                    if (nx >= 0 && ny >= 0 && nx < m && ny < n && grid[nx][ny] == 1) {
                        grid[nx][ny] = 2; // 变腐烂
                        queue.offer(new int[]{nx, ny});
                        fresh--;// 新鲜橘子 -1
                        rottedThisRound = true;
                        System.out.println("橘子腐烂: (" + nx + ", " + ny + ") 剩余新鲜橘子: " + fresh);
                    }
                }
            }

            // 只有这一轮有橘子腐烂才加分钟
            if (rottedThisRound) minutes++;
        }

        System.out.println("BFS 完毕，总共用时: " + minutes + " 分钟");
        return fresh == 0 ? minutes : -1;
    }

    // 测试用例
    public static void main(String[] args) {
        RottingOranges ro = new RottingOranges();

        int[][] grid1 = {{2,1,1},{1,1,0},{0,1,1}};
        int[][] grid2 = {{2,1,1},{0,1,1},{1,0,1}};
        int[][] grid3 = {{0,2}};

        System.out.println("测试用例 1，结果应为 4，实际: " + ro.orangesRotting(grid1));
        System.out.println("\n测试用例 2，结果应为 -1，实际: " + ro.orangesRotting(grid2));
        System.out.println("\n测试用例 3，结果应为 0，实际: " + ro.orangesRotting(grid3));
    }
}
