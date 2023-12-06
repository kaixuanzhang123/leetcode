package com.kaikai.leetcode.interviewTop100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**本题解决关键点  分组
思路：1 利用排序
     2 计数   比如将 [b,a,a,a,b,c] 编码成 a3b2c1，使用编码后的字符串作为 HashMap 的 Key 进行聚合
 */
public class 字母异位词分组49 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> collect = Arrays.stream(strs).collect(Collectors.groupingBy(str -> {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            return Arrays.toString(charArray);
        }));
        return new ArrayList<>(collect.values());
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(strs);
        for (List<String> list : lists) {
            System.out.println(list);
        }
    }
}
