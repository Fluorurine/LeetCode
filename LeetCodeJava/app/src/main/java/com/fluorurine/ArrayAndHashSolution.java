package com.fluorurine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ArrayAndHashSolution {
  // Leetcode 217 Solution - Easy
  public boolean containsDuplicate(int[] nums) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      if (map.containsKey(num)) {
        return true;
      } else {
        map.put(num, 1);
      }
    }
    return false;
  }

  // Leetcode 242 - Easy
  // https://leetcode.com/problems/valid-anagram/
  // Ideal is one hash array count the number of each character in the string
  // Note: Anagram # Panlindrome
  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    HashMap<Character, Integer> characters = new HashMap<>();
    for (char c : s.toCharArray()) {
      if (characters.containsKey(c)) {
        characters.put(c, characters.get(c) + 1);
      } else {
        characters.put(c, 1);
      }
    }
    for (char c : t.toCharArray()) {
      if (characters.containsKey(c) && characters.get(c) > 0) {
        characters.put(c, characters.get(c) - 1);
      } else {
        return false;
      }
    }

    return true;
  }

  // 1 - Two Sum - Easy
  // https://leetcode.com/problems/two-sum/
  // Take the number store it and it index into hashmap larter if that number with
  // another number statifies take that number and index out of the array.

  // THis is solution 2: if there is a number that accept this number as their
  // result return both indeices
  public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(nums[i])) {
        return new int[] { map.get(nums[i]), i };
      }
      map.put(target - nums[i], i);
    }
    return new int[] {};
  }

  // 49 - Valid Anagrám - Medium
  // https://leetcode.com/problems/group-anagrams/
  // Create a unique index to put them in hashmap and convert hashmap result to
  // final array.
  public List<List<String>> groupAnagrams(String[] strs) {
    HashMap<String, List<String>> map = new HashMap<>();
    for (String str : strs) {
      char[] chars = str.toCharArray();
      Arrays.sort(chars);
      String sortedString = new String(chars);
      if (map.containsKey(sortedString)) {
        map.get(sortedString).add(str);
      } else {
        map.put(sortedString, new ArrayList<>());
        map.get(sortedString).add(str);
      }
    }
    return new ArrayList<>(map.values());
  }
}