package leetcode.Algorithm;

import java.util.Arrays;

/**
 * Given an integer array nums sorted in non-decreasing order,
 * remove some duplicates in-place such that each unique element appears at most twice.
 * The relative order of the elements should be kept the same.
 * Input: nums = [1,1,1,2,2,3]
 * Output: 5, nums = [1,1,2,2,3,_]
 */
public class Solution80 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        int i = removeDuplicates(nums);
        System.out.println(i);
    }

    public static int removeDuplicates(int[] nums) {
        System.out.println(Arrays.toString(nums));
        int i = 1;
        for (int j = 2; j < nums.length; j++) {
            if(nums[i-1] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }
        System.out.println(Arrays.toString(nums));
        return i+1;
    }

}
