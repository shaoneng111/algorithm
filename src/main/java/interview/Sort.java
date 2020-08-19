/**
 * Baijiahulian.com Inc. Copyright (c) 2014-2019 All Rights Reserved.
 */
package interview;

/**
 * @author shaoneng
 * @date 2020/8/15 10:21 上午
 */
public class Sort {


    public static int[] sort(int[] input) {

        int length = input.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length-i-1; j++) {
                if (input[j] > input[j+1]) {
                    int temp = input[j];
                    input[j] = input[j+1];
                    input[j+1] = temp;
                }
            }
        }
        return input;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,4,5};
        int[] ret = sort(nums);
        for (int i = 0 ; i < ret.length; i++) {
            System.out.println(ret[i]);
        }

    }
}
