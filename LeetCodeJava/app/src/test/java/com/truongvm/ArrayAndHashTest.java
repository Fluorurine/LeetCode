/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.truongvm;

import static org.junit.jupiter.api.Assertions.*;

import com.arrayandhash.ArrayAndHashSolution;
import org.junit.jupiter.api.Test;

class ArrayAndHashTest {
  ArrayAndHashSolution solution = new ArrayAndHashSolution();

  // file:///home/zawarudo/Desktop/LeetCodeTruong/app/build/reports/tests/test/index.html
  // 217
  @Test
  void containDuplicateTest() {
    // assertEquals(test.containsDuplicate(new int[] {}), false);
    assertEquals(solution.containsDuplicate(new int[] {1, 1}), true, "Test 1 failed");
    assertEquals(
        solution.containsDuplicate(new int[] {1, 5, 6, 2, 3, 4, 2, 3, 1, 2, 4}),
        true,
        "Test 2 failed");
    assertEquals(
        solution.containsDuplicate(new int[] {1, 2, 4, 5, 7, 8, 111, 112}), false, "Test 3 failed");
    assertEquals(
        solution.containsDuplicate(new int[] {11, 2, 4, 5, 7, 8, 111, 112, 113, 113}),
        true,
        "Test 4 failed");
  }

  // 242
  @Test
  void vailidAnagramTest() {
    assertEquals(solution.isAnagram("anagram", "nagaram"), true, "Test 1 failed");
    assertEquals(solution.isAnagram("rat", "car"), false, "Test 2 failed");
    assertEquals(solution.isAnagram("a", "ab"), false, "Test 3 failed");
    assertEquals(solution.isAnagram("aacc", "ccac"), false, "Test 4 failed");
  }

  // 1
  @Test
  void twoSumTest() {
    assertArrayEquals(
        solution.twoSum(new int[] {2, 7, 11, 15}, 9), new int[] {0, 1}, "Test 1 failed");
    assertArrayEquals(solution.twoSum(new int[] {3, 2, 4}, 6), new int[] {1, 2}, "Test 2 failed");
    assertArrayEquals(solution.twoSum(new int[] {3, 3}, 6), new int[] {0, 1}, "Test 3 failed");
  }

  // 49
  @Test
  void groupAnagramsTest() {
    assertEquals(
        solution.groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"}).size(),
        3,
        "Test 1 failed");
    assertEquals(solution.groupAnagrams(new String[] {""}).size(), 1, "Test 2 failed");
    assertEquals(solution.groupAnagrams(new String[] {"a"}).size(), 1, "Test 3 failed");
    assertEquals(
        solution
            .groupAnagrams(
                new String[] {
                  "ass", "ssa", "sas", "", "testt", "tetts", "tttes", "ttest", "etstt", "hura",
                  "haru"
                })
            .size(),
        4,
        "Test 4 failed");
  }
}