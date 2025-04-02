package leetcode;

/**
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once.
 * The relative order of the elements should be kept the same.
 * Then return the number of unique elements in nums.
 * Input: nums = [1,1,2]
 * Output: 2, nums = [1,2,_]
 */
public class Solution26 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};
        int i = removeDuplicates(nums);
        System.out.println(i);
    }
    public static int removeDuplicates(int[] nums) {
        return 1;
    }
}
