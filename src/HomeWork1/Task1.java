package HomeWork1;

import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {
        int[] nums1 = new int[] { 1, 2, 3, 0, 0, 0 };
        int m = 3;
        int[] nums2 = new int[] { 2, 5, 6 };
        int n = 3;
        mergeArray(nums1, m, nums2, n);
    }

    public static void mergeArray(int[] nums1, int m, int[] nums2, int n ) {
        m--;
        n--;
        int i = nums1.length - 1;
        while (m >= 0 && n >= 0) {
            if (nums1[m] < nums2[n]) {
                nums1[i] = nums2[n];
                n--;
            }
            else  {
                nums1[i] = nums1[m];
                m--;
            }
            i--;
        }
        while (m >= 0) {
            nums1[i] = nums1[m];
            i--;
            m--;
        }
        while (n >= 0) {
            nums1[i] = nums2[n];
            i--;
            n--;
        }
        System.out.println(Arrays.toString(nums1));
    }
}
