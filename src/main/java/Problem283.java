import java.util.Arrays;

/**
 * 283. 移动零
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 * 示例 1:
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * 示例 2:
 * 输入: nums = [0]
 * 输出: [0]
 *
 * 提示:
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 *
 */
public class Problem283 {

    public static void moveZeroes(int[] nums) {
        if (nums.length <= 0) {
            return;
        }
        int j;
        for (int i = 0; i < nums.length; i++) {
            j = i+1;
            if (nums[i] == 0) {
                while (j < nums.length && nums[j] == 0) {
                    j++;
                }
                if (j < nums.length) {
                    swap(nums, i, j);
                }
            }

        }
        System.out.println(Arrays.toString(nums));
    }

    private static void swap(int[] nums, int m, int n) {
        int tmp = nums[m];
        nums[m] = nums[n];
        nums[n] = tmp;
    }



    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
    }

}
