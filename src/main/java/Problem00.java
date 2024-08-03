public class Problem00 {

    public static void main(String[] args) {
        int[] nums = {1,3,9,4,8};
        int k = lengthOfLIS(nums);
        System.out.println(k);
     }

    public static int lengthOfLIS(int[] nums) {
        if (nums.length <= 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(dp[i], max);
        }
        return max;
    }

}
