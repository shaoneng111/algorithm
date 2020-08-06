/**
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package array;

/**
 * 287.寻找重复数
 *
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 *
 * 示例 1:
 * 输入: [1,3,4,2,2]
 * 输出: 2
 *
 * 示例 2:
 * 输入: [3,1,3,4,2]
 * 输出: 3
 *
 * 说明：
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-duplicate-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *【通过】
 *
 * Runtime: 5 ms, faster than 18.36% of Java online submissions for Find the Duplicate Number.
 * Memory Usage: 41.8 MB, less than 5.09% of Java online submissions for Find the Duplicate Number.
 *
 * @author shaoneng
 * @date 2020/8/6 3:04 下午
 */
public class FindDuplicate {

    public int findDuplicate(int[] nums) {
        if (nums.length <= 1) {
            return -1;
        }
        int left = 1;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            int cnt = 0;
            for (int num : nums) {
                if (num <= mid) {
                    cnt++;
                }
            }
            if (cnt > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        int[] nums2 = {3,1,3,4,2};

        FindDuplicate f = new FindDuplicate();
        int i = f.findDuplicate(nums2);
        System.out.println(i);
    }
}
