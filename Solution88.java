package leetcode;

import java.util.Arrays;

/**
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
 * To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored.
 * nums2 has a length of n.
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 */
class Solution88 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0}, nums2 = new int[]{2,5,6};
//        int[] nums1 = new int[]{4, 5, 6, 0, 0, 0}, nums2 = new int[]{1, 2, 3};
        int m = 3, n = 3;
//        int[] nums1 =new int[]{0}; int m = 0; int[] nums2 = new int[]{1}; int n = 1;
        merge(nums1, m, nums2, n);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, l = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[l] = nums1[i];
                i--;
            } else {
                nums1[l] = nums2[j];
                j--;
            }
            l--;
        }
        while (j >= 0) {
            nums1[l] = nums2[j];
            j--;
            l--;
        }
        System.out.println(Arrays.toString(nums1).replace(" ", ""));
    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0;
        while (i < m + n && j < n) {
            if (nums1[i] == 0) {
                nums1[i] = nums2[j];
                i++;
                j++;
                continue;
            }
            if (nums2[j] == 0) {
                j++;
            }
            System.out.println("i---" + i);
            System.out.println("j---" + j);
            System.out.println("array--" + Arrays.toString(nums1));
            if (nums1[i] > nums2[j]) {
                int temp = nums1[i];
                nums1[i] = nums2[j];
                nums2[j] = temp;
                i++;
            } else {
                i++;
            }
        }

        System.out.println(Arrays.toString(nums1).replace(" ", ""));
    }

    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0, k = 0, l = 0, ll = 0;
        int[] arr = new int[m + n];
        while (l < m && ll < n) {
            if (nums1[i] == 0) {
                i++;
                continue;
            }
            if (nums2[j] == 0) {
                j++;
                continue;
            }
            if (nums1[i] < nums2[j]) {
                arr[k++] = nums1[i++];
                ++l;
            } else {
                arr[k++] = nums2[j++];
                ++ll;
            }
        }
        while (l < m) {
            arr[k++] = nums1[i++];
            ++l;
        }
        while (ll < n) {
            arr[k++] = nums2[j++];
            ++ll;
        }
        System.out.println(Arrays.toString(arr).replace(" ", ""));
    }


}
