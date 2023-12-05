package com.kaikai.leetcode.interviewTop100;

/**
 * Package: com.kaikai.leetcode.interviewTop100
 * Description：
 *
 * @author: zhangkaixuan
 * Date:  2022/9/1 11:46
 * Modified By:
 */

import java.util.*;

/**
 * 回溯算法模板
 * 回溯函数模板返回值以及参数（返回值一般是void，参数一般是输入数据和横向遍历的startIndex）
 * 回溯函数终止条件
 * 回溯搜索的遍历过程（横向和纵向）
 * // 存放结果的数据结构
 * // （除了设为全局变量外，还可以每次作为函数参数每次传递）
 * List<List<Integer>> result = new ArrayList<>();
 * LinkedList<Integer> path = new LinkedList<>();
 * <p>
 * void backtracking(参数) {
 * // 终止条件
 * if (终止条件) {
 * 存放结果; // 如：result.add(new ArrayList<>(path));
 * return;
 * }
 * <p>
 * // 横向遍历
 * for (选择：本层集合中元素（树中节点孩子的数量就是集合的大小）){ // 常根据终止条件进行剪枝
 * 处理节点; // 如：path.add(candidates[i]);
 * // 纵向遍历
 * backtracking(路径，选择列表); // 递归，注意startIndex是否改变
 * 回溯，撤销处理结果 // 如：path.removeLast();
 * }
 * }
 */


public class 电话号码的字母组合17 {
    public static List<String> letterCombinations(String digits) {
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        backTracking(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;

    }

    public static void backTracking(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
            return;
        } else {
            char c = digits.charAt(index);
            String nums = phoneMap.get(c);
            int length = nums.length();
            for (int i = 0; i < length; i++) {
                combination.append(nums.charAt(i));
                backTracking(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }

    public static void main(String[] args) {
        List<String> list = letterCombinations("23");
        for (String s : list) {
            System.out.println(s);
        }
    }
}
