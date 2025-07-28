public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;

        int row = 0;
        int col = n - 1; // 从右上角开始

        while (row < m && col >= 0) {
            int cur = matrix[row][col];
            if (cur == target) {
                return true;
            } else if (cur < target) {
                row++; // 去掉当前行
            } else {
                col--; // 去掉当前列
            }
        }

        return false;
    }

    // 测试入口
    public static void main(String[] args) {
        SearchMatrix sm = new SearchMatrix();

        int[][] matrix1 = {
                {1, 4, 7, 11},
                {2, 5, 8, 12},
                {3, 6, 9, 16},
                {10, 13, 14, 17}
        };
        System.out.println(sm.searchMatrix(matrix1, 5));   // true
        System.out.println(sm.searchMatrix(matrix1, 20));  // false

        int[][] matrix2 = {{}};
        System.out.println(sm.searchMatrix(matrix2, 1));   // false

        int[][] matrix3 = {
                {1, 2},
                {3, 4}
        };
        System.out.println(sm.searchMatrix(matrix3, 3));   // true
    }
}
