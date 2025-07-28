import java.util.*;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            System.out.println("矩阵为空，返回空列表");
            return result;
        }

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }

        while (top <= bottom && left <= right) {
            // 从左到右
            System.out.println("\n从左到右：top = " + top + ", left = " + left + ", right = " + right);
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
                System.out.println("  添加 matrix[" + top + "][" + i + "] = " + matrix[top][i]);
            }
            top++;

            // 从上到下
            System.out.println("从上到下：top = " + top + ", bottom = " + bottom + ", right = " + right);
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
                System.out.println("  添加 matrix[" + i + "][" + right + "] = " + matrix[i][right]);
            }
            right--;

            // 从右到左
            if (top <= bottom) {
                System.out.println("从右到左：bottom = " + bottom + ", right = " + right + ", left = " + left);
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                    System.out.println("  添加 matrix[" + bottom + "][" + i + "] = " + matrix[bottom][i]);
                }
                bottom--;
            }

            // 从下到上
            if (left <= right) {
                System.out.println("从下到上：bottom = " + bottom + ", top = " + top + ", left = " + left);
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                    System.out.println("  添加 matrix[" + i + "][" + left + "] = " + matrix[i][left]);
                }
                left++;
            }
        }

        System.out.println("\n最终结果：" + result);
        return result;
    }

    public static void main(String[] args) {
        SpiralMatrix solution = new SpiralMatrix();

        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
        };
        solution.spiralOrder(matrix);
    }
}
