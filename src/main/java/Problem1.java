import java.util.*;

/**
 * 1. 两数之和
 *
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 *
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 *
 * 示例 2：
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 *
 * 示例 3：
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 *
 *
 * 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？
 *
 *
 */
public class Problem1 {

    private static int[] getResult(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(target - nums[i])) {
                map.put(nums[i], i);
            } else {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {2,7,11,15};
        System.out.println(Arrays.toString(getResult(nums1, 9)));
        int[] nums2 = {3,2,4};
        System.out.println(Arrays.toString(getResult(nums2, 6)));
        int[] nums3 = {3,3};
        System.out.println(Arrays.toString(getResult(nums3, 6)));
    }
}
