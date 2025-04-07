package leetcode.Algorithm;

/**
 * You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
 * Each element nums[i] represents the maximum length of a forward jump from index i.
 * In other words, if you are at nums[i], you can jump to any nums[i + j]
 * where:
 * 0 <= j <= nums[i] and
 * i + j < n
 * Return the minimum number of jumps to reach nums[n - 1].
 * The test cases are generated such that you can reach nums[n - 1].
 * Example 1:
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 * Input: nums = [2,3,0,1,4]
 * Output: 2
 */
public class Solution45 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 0, 1, 4};
        int i = jump(nums);
        System.out.printf("i=%s", i);
    }

    /**
     * @param nums
     * @return
     */
    public static int jump(int[] nums) {
        int i = 0;
        int stepCount = 0;
        while (i < nums.length) {
            int step = nums[i];
            for (int j = 1; j < step; j++) {
                stepCount++;
                if (nums[i + j] > step - j) {
                    i = i+j;
                }

            }


        }
        return 1;
    }
}
