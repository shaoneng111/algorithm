/**
 * 64. 最小路径和
 *
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例 1：
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 *
 * 示例 2：
 * 输入：grid = [[1,2,3],[4,5,6]]
 * 输出：12
 *
 * 提示：
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 200
 *
 */
public class Problem0064 {

    public int minPathSum(int[][] grid) {

        if (grid.length <= 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        int[][] min = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    min[i][j] = grid[0][0];
                } else if (i == 0) {
                    min[i][j] = min[i][j-1] + grid[i][j];
                } else if (j == 0) {
                    min[i][j] = min[i-1][j] + grid[i][j];
                } else {
                    min[i][j] = Math.min(min[i][j-1], min[i-1][j]) + grid[i][j];
                }
            }
        }

        return min[m-1][n-1];

    }

}