/* (C)2024 */
package com.fluorurine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoPointerSolution {
  public boolean isPalindrome(String s) {
    // 125. Valid Palindrome - Easy
    // https://leetcode.com/problems/valid-palindrome/
    int l = 0, r = s.length() - 1;
    while (l <= r) {
      // This clever way to check the middle value too
      while (!Character.isLetterOrDigit(s.charAt(l)) && l < r) {
        l++;
      }
      while (!Character.isLetterOrDigit(s.charAt(r)) && l < r) {
        r--;
      }
      if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
        return false;
      } else {
        l++;
        r--;
      }
    }
    return true;
  }

  public int[] twoSumII(int[] numbers, int target) {
    // 167. Two Sum II - Input array is sorted - Easy
    // https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
    int l = 0, r = numbers.length - 1;
    while (l < r) {
      int sum = numbers[l] + numbers[r];
      if (sum == target) {
        return new int[] { l + 1, r + 1 };
      } else if (sum < target) {
        l++;
      } else {
        r--;
      }
    }
    return new int[] { -1, -1 };
  }

  // Method to find all unique triplets in the array which gives the sum of zero
  public List<List<Integer>> threeSum(int[] nums) {
    // 15. 3Sum - Medium
    // https://leetcode.com/problems/3sum/
    Arrays.sort(nums); // Sort the array
    List<List<Integer>> res = new ArrayList<>();

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0)
        break; // Since the array is sorted, no three numbers can sum to zero if the first
      // number is positive
      if (i > 0 && nums[i] == nums[i - 1])
        continue; // Skip duplicate values

      int l = i + 1, r = nums.length - 1;
      while (l < r) {
        int sum = nums[i] + nums[l] + nums[r];
        if (sum > 0) {
          r--; // Decrease the right pointer to reduce the sum
        } else if (sum < 0) {
          l++; // Increase the left pointer to increase the sum
        } else {
          res.add(Arrays.asList(nums[i], nums[l], nums[r])); // Found a triplet
          l++;
          r--;
          // Skip duplicate values for the left pointer
          while (l < r && nums[l] == nums[l - 1]) {
            l++;
          }
        }
      }
    }
    return res;
  }

  // 11. Container With Most Water - Medium
  // https://leetcode.com/problems/container-with-most-water/
  public int maxArea(int[] height) {
    int l = 0, r = height.length - 1;
    int maxArea = 0;
    while (l < r) {
      int h = Math.min(height[l], height[r]);
      maxArea = Math.max(maxArea, h * (r - l));
      if (height[l] < height[r]) {
        l++;
      } else {
        r--;
      }
    }
    return maxArea;
  }

  // 42. Trapping Rain Water - Hard
  // https://leetcode.com/problems/trapping-rain-water/
  public int trap(int[] height) {
    if (height == null || height.length == 0) {
      return 0;
    }

    int l = 0, r = height.length - 1;
    int leftMax = height[l], rightMax = height[r];
    int res = 0;
    while (l < r) {
      if (leftMax < rightMax) {
        l++;
        leftMax = Math.max(leftMax, height[l]);
        res += leftMax - height[l];
      } else {
        r--;
        rightMax = Math.max(rightMax, height[r]);
        res += rightMax - height[r];
      }
    }
    return res;
  }
}
