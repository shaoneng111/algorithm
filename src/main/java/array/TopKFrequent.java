/**
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package array;

import sun.nio.cs.ext.MS874;

import java.util.*;

/**
 * 347. 前 K 个高频元素
 * 难度：中等
 *
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 *
 *
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *  
 *
 * 提示：
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * 你可以按任意顺序返回答案
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 【已通过】
 * Runtime: 12 ms, faster than 61.41% of Java online submissions for Top K Frequent Elements.
 * Memory Usage: 42.2 MB, less than 70.25% of Java online submissions for Top K Frequent Elements.
 *
 * @author shaoneng
 * @date 2020/8/17 11:07 下午
 */
public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        // 使用map，统计每个元素出现的次数，元素为键，元素出现的次数为值
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i])+1);
            } else {
                map.put(nums[i], 1);
            }
        }

        // 遍历map，用最小堆保存频率最大的k个元素
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(map::get));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (pq.size() < k) {
                pq.add(entry.getKey());
            } else if (entry.getValue() > map.get(pq.peek())) {
                pq.remove();
                pq.add(entry.getKey());
            }
        }

        // 取出最小堆中的元素
        int[] res = new int[k];
        int i = 0;
        while (!pq.isEmpty()) {
            res[i++] = pq.poll();
        }
        return res;
    }

    public static void main(String[] args) {

    }


}
