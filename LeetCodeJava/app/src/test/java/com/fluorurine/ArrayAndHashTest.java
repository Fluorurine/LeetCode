/* (C)2024 */
package com.fluorurine;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import org.junit.Test;

public class ArrayAndHashTest {
  ArrayAndHashSolution solution = new ArrayAndHashSolution();

  // 217 Contains Duplicate Test
  @Test
  public void containDuplicateTest() {
    assertEquals("Test 1 failed", true, solution.containsDuplicate(new int[] { 1, 1 }));
    assertEquals(
        "Test 2 failed",
        true,
        solution.containsDuplicate(new int[] { 1, 5, 6, 2, 3, 4, 2, 3, 1, 2, 4 }));
    assertEquals(
        "Test 3 failed",
        false,
        solution.containsDuplicate(new int[] { 1, 2, 4, 5, 7, 8, 111, 112 }));
    assertEquals(
        "Test 4 failed",
        true,
        solution.containsDuplicate(new int[] { 11, 2, 4, 5, 7, 8, 111, 112, 113, 113 }));
  }

  // 242 Valid Anagram Test
  @Test
  public void vailidAnagramTest() {
    assertEquals("Test 1 failed", true, solution.isAnagram("anagram", "nagaram"));
    assertEquals("Test 2 failed", false, solution.isAnagram("rat", "car"));
    assertEquals("Test 3 failed", false, solution.isAnagram("a", "ab"));
    assertEquals("Test 4 failed", false, solution.isAnagram("aacc", "ccac"));
  }

  // 1 TwoSum Test
  @Test
  public void twoSumTest() {
    assertArrayEquals(
        "Test 1 failed", new int[] { 0, 1 }, solution.twoSum(new int[] { 2, 7, 11, 15 }, 9));
    assertArrayEquals(
        "Test 2 failed", new int[] { 1, 2 }, solution.twoSum(new int[] { 3, 2, 4 }, 6));
    assertArrayEquals("Test 3 failed", new int[] { 0, 1 }, solution.twoSum(new int[] { 3, 3 }, 6));
  }

  // 49 GroupAnagrams Test
  @Test
  public void groupAnagramsTest() {
    List<List<String>> result1 = solution.groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" });
    assertTrue(
        "Test 1 failed",
        result1.stream()
            .anyMatch(group -> group.containsAll(List.of("eat", "tea", "ate"))));
    assertTrue(
        "Test 1 failed",
        result1.stream().anyMatch(group -> group.containsAll(List.of("tan", "nat"))));
    assertTrue(
        "Test 1 failed",
        result1.stream().anyMatch(group -> group.containsAll(List.of("bat"))));

    List<List<String>> result7 = solution.groupAnagrams(new String[] { "abc", "def", "ghi", "jkl" });
    assertTrue(
        "Test 7 failed",
        result7.stream().anyMatch(group -> group.containsAll(List.of("abc"))));
    assertTrue(
        "Test 7 failed",
        result7.stream().anyMatch(group -> group.containsAll(List.of("def"))));
    assertTrue(
        "Test 7 failed",
        result7.stream().anyMatch(group -> group.containsAll(List.of("ghi"))));
    assertTrue(
        "Test 7 failed",
        result7.stream().anyMatch(group -> group.containsAll(List.of("jkl"))));

    List<List<String>> result8 = solution.groupAnagrams(new String[] { "aabb", "bbaa", "abab", "baba", "baab" });
    assertTrue(
        "Test 8 failed",
        result8.stream()
            .anyMatch(
                group -> group.containsAll(
                    List.of("aabb", "bbaa", "abab", "baba", "baab"))));
  }

  // 347 TopKFrequent Test
  @Test
  public void topKFrequentTest() {
    assertArrayEquals(
        "Test 1 failed",
        new int[] { 1, 2 },
        solution.topKFrequent(new int[] { 1, 1, 1, 2, 2, 3 }, 2));
    assertArrayEquals("Test 2 failed", new int[] { 1 }, solution.topKFrequent(new int[] { 1 }, 1));
    assertArrayEquals(
        "Test 3 failed", new int[] { 1, 2 }, solution.topKFrequent(new int[] { 1, 2 }, 2));
    assertArrayEquals(
        "Test 4 failed",
        new int[] { 1, 2 },
        solution.topKFrequent(new int[] { 1, 1, 1, 2, 2, 2 }, 2));
    assertArrayEquals(
        "Test 5 failed",
        new int[] { 3, 1 },
        solution.topKFrequent(new int[] { 3, 3, 3, 1, 1, 2 }, 2));
    assertArrayEquals(
        "Test 6 failed",
        new int[] { 4, 5 },
        solution.topKFrequent(new int[] { 4, 4, 4, 5, 5, 5, 6 }, 2));
  }
}
