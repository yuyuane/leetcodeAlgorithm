package leetcode.Algorithm;

import java.util.Arrays;

/**
 * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
 * The order of the elements may be changed.
 * Then return the number of elements in nums which are not equal to val.
 */
public class Solution27 {

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        int val = 2;
        int i = removeElement(nums, val);
        System.out.println(i);
    }

    public static int removeElement(int[] nums, int val) {
        int i = 0;
        int l = nums.length;
        int j = l - 1;
        int mid = j / 2;
        while (i <= j) {
            if (nums[i] == val) {
                l--;
                if (nums[j] == val) {
                    nums[j] = '_';
                    j--;
                    continue;
                } else {
                    nums[i] = nums[j];
                    nums[j] = '_';
                    j--;
                }
            }
            i++;
        }
        System.out.println(Arrays.toString(nums).replace("95", "_"));
        return l;
    }
}
