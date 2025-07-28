package 图论;

public class NumIslands {
    public int numsIslands(char[][] grid){
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (grid[i][j] == '1'){
                    System.out.println("发现新的岛屿，起点为: (" + i + ", " + j + ")");
                    dfs(grid, i, j);
                    count++;
                    System.out.println("当前岛屿处理完毕，累计岛屿数: " + count);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j){
        int rows = grid.length;
        int cols = grid[0].length;
        if (i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] != '1'){
            return;
        }

        System.out.println("访问陆地: (" + i + ", " + j + ")，标记为已访问");
        grid[i][j] = '0'; // 淹没当前陆地

        dfs(grid, i + 1, j); // 向下探索
        dfs(grid, i, j + 1); // 向右探索
        dfs(grid, i, j - 1); // 向左探索
        dfs(grid, i - 1, j); // 向上探索
    }

    public static void main(String[] args) {
        NumIslands sol = new NumIslands();

        // 测试用例 1：一个小岛
        char[][] grid1 = {
                {'1', '1', '0', '0'},
                {'1', '1', '0', '0'},
                {'0', '0', '0', '1'},
                {'0', '0', '1', '1'}
        };
        System.out.println("=== 测试用例 1 ===");
        System.out.println("岛屿数量: " + sol.numsIslands(grid1));
        System.out.println();

        // 测试用例 2：全是水
        char[][] grid2 = {
                {'0', '0', '0'},
                {'0', '0', '0'}
        };
        System.out.println("=== 测试用例 2 ===");
        System.out.println("岛屿数量: " + sol.numsIslands(grid2));
        System.out.println();

        // 测试用例 3：全是陆地
        char[][] grid3 = {
                {'1', '1'},
                {'1', '1'}
        };
        System.out.println("=== 测试用例 3 ===");
        System.out.println("岛屿数量: " + sol.numsIslands(grid3));
        System.out.println();

        // 测试用例 4：斜着相连的岛屿
        char[][] grid4 = {
                {'1', '0', '0'},
                {'0', '1', '0'},
                {'0', '0', '1'}
        };
        System.out.println("=== 测试用例 4 ===");
        System.out.println("岛屿数量: " + sol.numsIslands(grid4));
        System.out.println();
    }
}
