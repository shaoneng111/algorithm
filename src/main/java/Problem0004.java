/**
 *
 * 4. 寻找两个正序数组的中位数
 *
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 * 示例 1：
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 *
 * 示例 2：
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 *
 * 提示：
 *
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 *
 *
 */
public class Problem0004 {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        return  (getKth(nums1, nums2, 0, len1-1,0, len2-1, (len1+len2+1)/2)
                + getKth(nums1, nums2, 0, len1-1, 0, len2-1, (len1+len2+2)/2)) * 0.5;
    }

    private static int getKth(int[] num1, int[] num2, int start1, int end1, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        if (len1 <= 0) {
            return num2[start2+k-1];
        } else if (len2 <= 0) {
            return num1[start1+k-1];
        } else if (k == 1) {
            return Math.min(num1[start1], num2[start2]);
        } else {
            int half = k/2;
            int i = start1 + Math.min(len1, half) - 1;
            int j = start2 + Math.min(len2, half) - 1;
            if (num1[i] < num2[j]) {
                return getKth(num1, num2, i+1, end1, start2, end2, k-(i-start1+1));
            } else {
                return getKth(num1, num2, start1, end1, j+1, end2, k-(j-start2+1));
            }
        }
    }

    public static void main(String[] args) {
        int[] num1 = {1, 2};
        int[] num2 = {1, 2, 3, 4, 5, 6, 7, 8 ,9, 10};
        System.out.println(findMedianSortedArrays(num1, num2));

        int[] num11 = {1, 3};
        int[] num21 = {2};
        System.out.println(findMedianSortedArrays(num11, num21));

        int[] num12 = {1};
        int[] num22 = {2, 3, 4, 5, 6};
        System.out.println(findMedianSortedArrays(num12, num22));
    }
}
