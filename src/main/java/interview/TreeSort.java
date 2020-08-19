/**
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package interview;

/**
 * @author shaoneng
 * @date 2020/8/15 7:41 下午
 */
public class TreeSort {

    public int[] sort(int[] nums) {
        int length = nums.length;
        int[] maxA = buildMaxA(nums);
        for (int i = 0 ; i < length; i++) {

        }

        return nums;
    }

    /**
     * 构建大顶堆
     * @param nums
     * @return
     */
    public int[] buildMaxA(int[] nums) {
        int length = nums.length;

        for (int i = length/2 ; i >= 0; i++) {
            int sonMaxIndex = compareMaxIndex(nums, i);
            if (sonMaxIndex > nums[i]) {
                int tmp = nums[sonMaxIndex];
                nums[sonMaxIndex] = nums[i];
                nums[i] = tmp;
            }
        }

        return nums;
    }

    /**
     *
     * @param nums
     * @param index
     * @return
     */
    public int compareMaxIndex(int[] nums, int index) {
        int sonMaxIndex = nums[index*2] > nums[index*2+1] ? index*2 : index*2+1;
        return sonMaxIndex;
    }

    public static void main(String[] args) {

    }
}
