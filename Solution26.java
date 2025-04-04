package leetcode.Algorithm;

import java.util.Arrays;

/**
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once.
 * The relative order of the elements should be kept the same.
 * Then return the number of unique elements in nums.
 * Input: nums = [0,0,1,1,1,2,2,3,3,4]
 * Output: 2, nums = [0,1,2,3,4,_,_,_,_,_]
 */

public class Solution26 {
    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        int i = removeDuplicates(nums);
        System.out.println(i);
    }

    /**
     * 双指针 跑
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        System.out.println(Arrays.toString(nums));
        return i + 1;
    }

    /**
     * 先判断出重复的用——标识，再循环将——移到最后
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates01(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int n = 0;
        while (i <= j) {
            //记住当前值，判断后续有几个重复值
            int k = i + 1;
            while (k < j && nums[i] == nums[k]) {
                //替换掉k键的值
                nums[k] = '_';
                k++;
                n++;
            }
            i = k;
        }
        System.out.println(Arrays.toString(nums).replace("95", "_"));
        int[] newArray = new int[j + 1];
        int l = 0;
        int k = 0;
        while (l <= j) {
            if (nums[l] != '_') {
                newArray[k++] = nums[l];
            }
            l++;
        }
        if (k < j) {
            for (int h = k - 1; h < j; h++) {
                newArray[k++] = '_';
            }
        }
        nums = newArray;
        System.out.println(Arrays.toString(newArray).replace("95", "_"));
        return nums.length - n;
    }
    /**
     * 先替换掉重复的，再做排序
     */


}
