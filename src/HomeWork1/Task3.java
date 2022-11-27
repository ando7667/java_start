package HomeWork1;

import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {
        int[]  nums = new int[] {3, 2, 2, 3};
        int val = 3;
        int i = removeElement(nums, val);
        System.out.println(i +", nums = " + Arrays.toString(nums));

    }
    public static int removeElement(int[] nums, int val) {
        int i = 0;
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] != val) {
                nums[i] = nums[k];
                i++;
            }
        }
        return i;
    }
}
