package leetcode.Algorithm;

/**
 * You are given an integer array nums.
 * You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
 * Return true if you can reach the last index, or false otherwise.
 * Example 1:
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 * 5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0 // true
 */
public class Solution55 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 1, 4};
        boolean b = canJump(nums);
        System.out.println(b);
    }

    /**
     * maximum jump length means 最大长度，不是说一定要跳完所有长度，若在step过程中的时候，遇到更到的长度值，则可重新计数跳跃！！！
     *
     * @param nums
     * @return Boolean
     */
    public static boolean canJump(int[] nums) {
        // compare the index i and the max index
        int i = 0; //循环
        int minVal = nums[0];
        while (i < nums.length) {
            if (nums[i] < minVal) {
                minVal = nums[i];
            }
            int step = nums[i];
            int checkI = 0;
            if (i == nums.length - 1 || step + i >= nums.length - 1) {
                return true;
            }
            if (step <= 0) {
                return false;
            }
            for (int j = 1; j < step; j++) {
                // 长度-val = 最后的索引-当前索引i + j
                if (nums[i + j] < minVal) {
                    minVal = nums[i + j];
                }
                if (nums[i + j] >= nums.length - 1 - i - j) {
                    return true;
                } else {
                    if (nums[i + j] > step - j) {
                        i = i + j;
                        checkI = 1;
                        break;
                    }
                }
            }
            // After for runs break,it also runs this condition!!!
            if (checkI == 0) {
                i = i + step;
            }
        }
        return false;
    }
}
