package com.fluorurine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class ArrayAndHashTest {
  ArrayAndHashSolution solution = new ArrayAndHashSolution();

  // 217
  @Test
  public void containDuplicateTest() {
    // assertEquals(test.containsDuplicate(new int[] {}), false);
    assertEquals("Test 1 failed", true, solution.containsDuplicate(new int[] { 1, 1 }));
    assertEquals("Test 2 failed", true, solution.containsDuplicate(new int[] { 1, 5, 6, 2, 3, 4, 2, 3, 1, 2, 4 }));
    assertEquals("Test 3 failed", false, solution.containsDuplicate(new int[] { 1, 2, 4, 5, 7, 8, 111, 112 }));
    assertEquals("Test 4 failed", true,
        solution.containsDuplicate(new int[] { 11, 2, 4, 5, 7, 8, 111, 112, 113, 113 }));
  }

  // 242
  @Test
  public void vailidAnagramTest() {
    assertEquals("Test 1 failed", true, solution.isAnagram("anagram", "nagaram1"));
    assertEquals("Test 2 failed", false, solution.isAnagram("rat", "car"));
    assertEquals("Test 3 failed", false, solution.isAnagram("a", "ab"));
    assertEquals("Test 4 failed", false, solution.isAnagram("aacc", "ccac"));
  }

  // 1
  @Test
  public void twoSumTest() {
    assertArrayEquals("Test 1 failed", new int[] { 0, 1 }, solution.twoSum(new int[] { 2, 7, 11, 15 }, 9));
    assertArrayEquals("Test 2 failed", new int[] { 1, 2 }, solution.twoSum(new int[] { 3, 2, 4 }, 6));
    assertArrayEquals("Test 3 failed", new int[] { 0, 1 }, solution.twoSum(new int[] { 3, 3 }, 6));
  }

  // 49
  @Test
  public void groupAnagramsTest() {
    assertEquals("Test 1 failed", 3,
        solution.groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }).size());
    assertEquals("Test 2 failed", 1, solution.groupAnagrams(new String[] { "" }).size());
    assertEquals("Test 3 failed", 1, solution.groupAnagrams(new String[] { "a" }).size());
    assertEquals("Test 4 failed", 4, solution.groupAnagrams(new String[] {
        "ass", "ssa", "sas", "", "testt", "tetts", "tttes", "ttest", "etstt", "hura", "haru"
    }).size());
  }
}
