// =========================================================================================
// https://leetcode.com/problems/contains-duplicate-ii/ - использовать мапу, либо подумать
// как обойтись сетом.
// Input: nums = [1,2,3,1], k = 3
// Output: true
// Input: nums = [1,0,1,1], k = 1
// Output: true
// Input: nums = [1,2,3,1,2,3], k = 2
// Output: false
// -----------------------------------------------------------------------------------------

package HomeWork5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Task1 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 2, 3};
        int k = 2;
        System.out.println(containsNearbyDuplicate(nums, k));
        System.out.println(containsNearbyDuplicateSet(nums, k));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && (i - map.get(nums[i]) <= k)) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

    // решение от авторов через скользящее окно размером k элементов
    public static boolean containsNearbyDuplicateSet(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}
