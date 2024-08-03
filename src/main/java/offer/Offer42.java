package offer;

/**
 * 剑指 Offer 42. 连续子数组的最大和
 *
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)。
 *
 * 示例1:
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * 提示：
 * 1 <= arr.length <= 10^5
 * -100 <= arr[i] <= 100
 *
 */
public class Offer42 {

    public int maxSubArray(int[] nums) {

        int len = nums.length;
        int[] maxArray = new int[len];

        for (int i = 0; i < len; i++) {
            if (i == 0) {
                maxArray[0] = nums[0];
                continue;
            }
            if (nums[i] >= 0) {
                maxArray[i] = Math.max(maxArray[i-1] + nums[i], nums[i]);
            } else {
                maxArray[i] = maxArray[i-1];
            }
        }
        return maxArray[len-1];
    }

    public static void main(String[] args) {

    }
}
