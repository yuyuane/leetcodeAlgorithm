package leetcode.Algorithm;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Try to come up with as many solutions as you can.
 * There are at least three different ways to solve this problem.
 * O(1)
 * <p>
 * Input: nums = [1,2,3], k = 4
 * Output: [3,1,2]
 * <p>
 * Input: nums = [1,2], k = 3
 * Output: [2,1]
 * <p>
 * Input: nums = [1,2], k = 2
 * Output: [1,2]
 */
public class Solution189 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2};
        rotate(nums, 5);
    }

    public static void rotate(int[] nums, int k) {
        //如果K<nums.length ,结果无误，若k=nums.length,则失效，倒序
        if (k > nums.length) {
            k = k%(nums.length);
        }
        int l = nums.length - 1;
        int i = k - 1;
        int m = k - 1;
        int[] arr = new int[k];
        for (int j = l; j >= 0; j--) {
            if (i >= 0) {
                arr[i] = nums[j];
                i--;
            }
            if (j <= k - 1 && m >= 0) {
                nums[j] = arr[m];
                m--;
            } else {
                nums[j] = nums[j - k];
            }
        }

        System.out.println(Arrays.toString(nums));

    }

    /**
     * 倒过去赋值
     *
     * @param nums
     * @param k
     */
    public static void rotate1(int[] nums, int k) {
        int l = nums.length - 1;
        while (k > 0) {
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
    public static void rotate2(int[] nums, int k) {
        //如果K<nums.length ,结果无误，若k=nums.length,则失效，倒序
        if (k > nums.length) {
            int j = nums.length - 1;
            for (int i = 0; i < j; i++) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j--;
            }
        } else {
            int l = nums.length - 1;
            int i = k - 1;
            int m = k - 1;
            int[] arr = new int[k];
            for (int j = l; j >= 0; j--) {
                if (i >= 0) {
                    arr[i] = nums[j];
                    i--;
                }
                if (j <= k - 1 && m >= 0) {
                    nums[j] = arr[m];
                    m--;
                } else {
                    nums[j] = nums[j - k];
                }
            }
        }
        System.out.println(Arrays.toString(nums));

    }
}
