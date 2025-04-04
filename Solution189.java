package leetcode;

import java.util.Arrays;

/**
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
 * O(1)
 */
public class Solution189 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,-100,3,99};
        rotate(nums, 2);
    }

    /**
     * 倒过去赋值
     *
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        int l = nums.length - 1;
        while (k>0){
            int temp = nums[l];
            for (int j = l; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
            k--;
        }
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 拼数组，截取，再拼接
     *
     * @param nums
     * @param k
     */
    public static void rotate1(int[] nums, int k) {

    }
}
