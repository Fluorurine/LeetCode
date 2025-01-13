/* (C)2024 */
package com.fluorurine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// @SuppressWarnings("unchecked")
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

  // 49 - Group Anagrám - Medium
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

  // 347 - Top K Frequent Elements - Medium
  // https://leetcode.com/problems/top-k-frequent-elements/
  // Bucket sort
  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> count = new HashMap<>();
    List<Integer>[] freq = new List[nums.length + 1];
    for (int num : nums) {
      count.put(num, count.getOrDefault(num, 0) + 1);
    }
    for (int i = 0; i < freq.length; i++) {
      freq[i] = new ArrayList<>();
    }
    // This is reference to entry and then change those value
    for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
      freq[entry.getValue()].add(entry.getKey());
    }
    int[] res = new int[k];
    int index = 0;
    for (int i = freq.length - 1; i > 0 && index < k; i--) {
      // This actually clever it only run when there is a value in the array
      for (int n : freq[i]) {
        // increase the index and return it value to n (or before?)
        res[index++] = n;
        if (index == k) {
          return res;
        }
      }
    }
    return res;
  }

  // 271 - Encode and Decode Strings - Medium
  // https://leetcode.com/problems/encode-and-decode-strings/
  public class EncodeAndDecodeStrings {

    public String encode(List<String> strs) {
      StringBuilder res = new StringBuilder();
      for (String s : strs) {
        res.append(s.length()).append('#').append(s);
      }
      return res.toString();
    }

    public List<String> decode(String str) {
      List<String> res = new ArrayList<>();
      int i = 0;
      while (i < str.length()) {
        int j = i;
        while (str.charAt(j) != '#') {
          j++;
        }
        int length = Integer.parseInt(str.substring(i, j));
        i = j + 1;
        j = i + length;
        res.add(str.substring(i, j));
        i = j;
      }
      return res;
    }
  }

  // 238 - Product of Array Except Self - Medium
  // https://leetcode.com/problems/product-of-array-except-self/
  // This is a solution with O(n) time complexity and O(1) space complexity
  public int[] productExceptSelf(int[] nums) {
    // In Java we can use trick to avoid null or go the same way as python the basic
    // ideal doesn't change
    int[] res = new int[nums.length];
    res[0] = 1;
    for (int i = 1; i < nums.length; i++) {
      res[i] = res[i - 1] * nums[i - 1];
    }
    int right = 1;
    for (int i = nums.length - 1; i >= 0; i--) {
      res[i] *= right;
      right *= nums[i];
    }
    return res;
  }

  // 36 - Valid Sudoku - Medium
  // https://leetcode.com/problems/valid-sudoku/
  public boolean isValidSudoku(char[][] board) {
    Map<Integer, Set<Character>> cols = new HashMap<>();
    Map<Integer, Set<Character>> rows = new HashMap<>();
    Map<String, Set<Character>> squares = new HashMap<>();

    for (int r = 0; r < 9; r++) {
      for (int c = 0; c < 9; c++) {
        if (board[r][c] == '.')
          continue;

        String squareKey = (r / 3) + "," + (c / 3);
        // ComputeIfAbsent is a new method in Java 8, which allows you to compute a new
        // value for a given key using a lambda expression.
        // row.r = row.getOrDefault(r, new HashSet<>());
        if (rows.computeIfAbsent(r, k -> new HashSet<>()).contains(board[r][c])
            || cols.computeIfAbsent(c, k -> new HashSet<>()).contains(board[r][c])
            || squares.computeIfAbsent(squareKey, k -> new HashSet<>())
                .contains(board[r][c])) {
          return false;
        }

        rows.get(r).add(board[r][c]);
        cols.get(c).add(board[r][c]);
        squares.get(squareKey).add(board[r][c]);
      }
    }
    return true;
  }

  // 128 - Longest Consecutive Sequence - Medium
  // https://leetcode.com/problems/longest-consecutive-sequence/
  public int longestConsecutive(int[] nums) {
    Set<Integer> numSet = new HashSet<>();
    for (int num : nums) {
      numSet.add(num);
    }
    int longest = 0;
    for (int num : numSet) {
      if (!numSet.contains(num - 1)) {
        int currentNum = num;
        int currentStreak = 1;
        while (numSet.contains(currentNum + 1)) {
          currentNum += 1;
          currentStreak += 1;
        }
        longest = Math.max(longest, currentStreak);
      }
    }
    return longest;
  }
  // Map<Integer, Integer> mp = new HashMap<>();
  // int res = 0;

  // for (int num : nums) {
  // if (!mp.containsKey(num)) {
  // mp.put(num, mp.getOrDefault(num - 1, 0) + mp.getOrDefault(num + 1, 0) + 1);
  // mp.put(num - mp.getOrDefault(num - 1, 0), mp.get(num));
  // mp.put(num + mp.getOrDefault(num + 1, 0), mp.get(num));
  // res = Math.max(res, mp.get(num));
  // }
  // }
  // return res;
  // }
  // Runtime: 79 ms, faster than 37.03% of Java online submissions for Longest
  // Consecutive Sequence.
  // Memory Usage: 57.5 MB, less than 77.17% of Java online submissions for
  // Longest Consecutive Sequence
  // Other method are sort base on the number of element in the array less element
  // so they are faster
  // For me Go set: dec14652-d300-4dfa-957c-8adcd9a8a8e3
}
