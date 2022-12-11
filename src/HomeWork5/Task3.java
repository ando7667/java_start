// =========================================================================================
// https://leetcode.com/problems/intersection-of-two-arrays-ii/
//  используем ровно одну мапу, в мапе храним меньший из массивов
// Input: nums1 = [1,2,2,1], nums2 = [2,2]
//  Output: [2,2]
//
// Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
// Output: [4,9]
// -----------------------------------------------------------------------------------------

package HomeWork5;

import java.util.*;

public class Task3 {
    public static void main(String[] args) {
//        int[] nums1 = {1,2,2,1};
//        int[] nums2 = {2,2};
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};

        System.out.println(Arrays.deepToString(new int[][]{intersect(nums1, nums2)}));

    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        // в массив nums1 заносим меньший по размеру массив, т.к. для нахождения пересечения массивов
        // нет смысла хранить в Map максимальный элемент
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        // список для пересечений
        List<Integer> inter = new ArrayList<>();
        // мапа для посчета
        Map<Integer, Integer> map = new HashMap<>();

        // подсчитаем количество слов в массиве nums1 и положим слова в мапу
        for (int num : nums1) {
            map.putIfAbsent(num, 0);
            map.put(num, map.get(num) + 1);
        }

        // обходим массив nums2 и ищем совпадения с массивом nums1
        for (int num : nums2) {
            // если текущее слово есть в мапе, то добавляем его в список пересечений
            if (map.containsKey(num) && map.get(num) > 0) {
                inter.add(num);
                map.put(num, map.get(num) - 1);
            }
        }

        // конвертируем список inter в массив типа int
        int[] ans = new int[inter.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = inter.get(i);
        }
        return ans;
    }
}
