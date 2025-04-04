package leetcode;

import java.util.HashMap;

/**
 * Given an array nums of size n, return the majority element.
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 * You may assume that the majority element always exists in the array.
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 * O(1)
 */
public class Solution169 {
    public static void main(String[] args) {
        int[] nums = new int[]{1};
        int i = majorityElement(nums);
        System.out.println(i);
    }

    public static int majorityElement(int[] nums) {
        int n = nums.length / 2;
        if(nums.length == 1) return nums[0];
        HashMap<Integer, Integer> newArr = new HashMap<>();
        int v = 0;
        for (int i = 0; i < nums.length; i++) {
            if (newArr.get(nums[i]) != null) {
                Integer k = newArr.get(nums[i]);
                newArr.put(nums[i],k+1);
                if (k+1 > n) {
                    v=nums[i];
                }
            }else{
                newArr.put(nums[i],1);
            }
        }
        return v;
    }
}
