// =========================================================================================
// https://leetcode.com/problems/count-common-words-with-one-occurrence/
//  используем ровно одну мапу, в мапе храним меньший из массивов
// Input: words1 = ["b","bb","bbb"], words2 = ["a","aa","aaa"]
// Output: 0

// Input: words1 = ["a","ab"], words2 = ["a","a","a","ab"]
// Output: 1
// -----------------------------------------------------------------------------------------

package HomeWork5;

import java.util.HashMap;
import java.util.Map;

public class Task2 {
    public static void main(String[] args) {
//        String[] words1 = {"b", "bb", "bbb"};
//        String[] words2 = {"a", "aa", "aaa"};
        String[] words1 = {"a", "ab"};
        String[] words2 = {"a", "a", "a", "ab"};

        System.out.println(countWords(words1, words2));

    }

    public static int countWords(String[] words1, String[] words2) {
        if (words1.length > words2.length) {
            return countWords(words2, words1);
        }

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < words1.length; i++) {
            map.putIfAbsent(words1[i], 0);
            map.put(words1[i], map.get(words1[i]) + 1);
        }

        int ans = 0;
        for (int i = 0; i < words2.length; i++) {
            if (map.containsKey(words2[i]) && map.get(words2[i]) < 2) {
                map.put(words2[i], map.get(words2[i]) - 1);
            }
        }
        for (var e : map.entrySet()) {
            if (e.getValue() == 0) {
                ans++;
            }
        }
        return ans;
    }
}
