import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 *
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 *
 * 你返回所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 *
 * 示例 2：
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 *
 * 示例 3：
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0 。
 *
 */
public class Problem0015 {


    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> resultList = new ArrayList<>();

        Arrays.sort(nums);
        int len = nums.length;
        if (len < 3) {
            return new ArrayList<>();
        }
//        if (len == 3 && nums[0] + nums[1] + nums[2] == 0) {
//            List<Integer> result = Arrays.asList(nums[0], nums[1], nums[2]);
//            resultList.add(result);
//            return resultList;
//        }

        for (int place = 0; place <= len-3; place++) {
            if (place >= 1 && nums[place] == nums[place-1]) {
                continue;
            }
            int start = place+1;
            while (start < len-2) {
                int end = len-1;

                while (end >= place+2) {
                    while (end >= place+2 && nums[end] == nums[end-1]) {
                        end--;
                    }
                    if (nums[place] + nums[start] + nums[end] == 0) {
                        List<Integer> result = Arrays.asList(nums[place], nums[start], nums[end]);
                        resultList.add(result);
                        while (start <= len-2 && nums[start+1] == nums[start]) {
                            start++;
                        }
                    }
                    end--;
                }
                if (end <= place+1) {
                    start++;
                }
            }
        }
        return resultList;
    }

    public static void main(String[] args) {

//        int[] nums = {-1,0,1,2,-1,-4};
//        System.out.println(threeSum(nums));

        int[] nums1 = {0,0,0};
        System.out.println(threeSum(nums1));
    }
}
