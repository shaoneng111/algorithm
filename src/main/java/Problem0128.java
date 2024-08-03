import java.util.LinkedHashSet;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * 128. 最长连续序列
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 请你设计并实现时间复杂度为O(n) 的算法解决此问题。
 *
 * 示例 1：
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 * 示例 2：
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 *
 * 提示：
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 *
 *
 */
public class Problem0128 {

    public static int longestConsecutive(int[] nums) {

        if (nums.length <= 0) {
            return 0;
        }
        TreeSet<Integer> set = new TreeSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int subMaxLength = 1;
        int max = 1;
        int currentNum = set.pollFirst();
        int tmp;

        while (!set.isEmpty()) {
            tmp = set.pollFirst();
            if (tmp == currentNum+1) {
                subMaxLength++;
            } else {
                subMaxLength = 1;
            }
            currentNum = tmp;
            max = Math.max(max, subMaxLength);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        int max = longestConsecutive(nums);
        System.out.println(max);
    }
}
