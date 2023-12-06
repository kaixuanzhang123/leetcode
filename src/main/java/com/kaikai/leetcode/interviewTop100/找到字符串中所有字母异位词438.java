package com.kaikai.leetcode.interviewTop100;

import java.util.*;

public class 找到字符串中所有字母异位词438 {
    public static List<Integer> findAnagrams1(String s, String p) {
        ArrayList<Integer> list = new ArrayList<>();
        char[] chars = s.toCharArray();
        Map<Character, Integer> pMap = getStrMap1(p.toCharArray());
        for (int i = 0; i < chars.length - p.length() + 1; i++) {
            String substring = s.substring(i, i + p.length());
            if (diffStr1(substring, pMap)) {
                list.add(i);
            }
        }
        return list;
    }

    //这种判断方式会导致 时间超时
    public static boolean diffStr1(String s, Map<Character, Integer> pMap) {
        Map<Character, Integer> sMap = getStrMap1(s.toCharArray());
        if (sMap.keySet().size() != pMap.keySet().size()) {
            return false;
        }
        for (Map.Entry<Character, Integer> entry : sMap.entrySet()) {
            if (!entry.getValue().equals(pMap.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    private static Map<Character, Integer> getStrMap1(char[] sChar) {
        Map<Character, Integer> strMap = new HashMap<>();
        for (int i = 0; i < sChar.length; i++) {
            if (strMap.containsKey(sChar[i])) {
                strMap.put(sChar[i], strMap.get(sChar[i]) + 1);
            } else {
                strMap.put(sChar[i], 1);
            }
        }
        return strMap;
    }


    //解法二： 可以正确通过计算   关键点在于，字符串相似的比较方式
    public static List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> list = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - p.length() + 1; i++) {
            String substring = s.substring(i, i + p.length());
            if (diffStr(substring, p)) {
                list.add(i);
            }
        }
        return list;
    }

    //这种判断方式会导致 时间超时
    public static boolean diffStr(String s, String p) {
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
            pCount[p.charAt(i) - 'a']++;
        }
        if (Arrays.equals(sCount, pCount)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "abab";
        String p = "ab";
        System.out.println(findAnagrams(s, p));
    }
}
