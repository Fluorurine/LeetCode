/* (C)2024 */
package com.fluorurine;

import java.util.Arrays;

public class BinarySearchSolution {
  public int search(int[] nums, int target) {
    // 704. Binary Search - Easy
    // https://leetcode.com/problems/binary-search/
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return -1;
  }

  public boolean searchMatrix(int[][] matrix, int target) {
    // 74. Search a 2D Matrix - Medium
    // https://leetcode.com/problems/search-a-2d-matrix/
    int left = 0;
    int right = matrix.length * matrix[0].length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      int row = mid / matrix[0].length;
      int col = mid % matrix[0].length;
      if (matrix[row][col] == target) {
        return true;
      } else if (matrix[row][col] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return false;
  }

  public int minEatingSpeed(int[] piles, int h) {
    // 875. Koko Eating Bananas - Medium
    // https://leetcode.com/problems/koko-eating-bananas/
    int left = 1;
    int right = Arrays.stream(piles).max().getAsInt();
    while (left <= right) {
      int mid = left + (right - left) / 2;
      int hours = 0;
      for (int pile : piles) {
        hours += Math.ceil((double) pile / mid);
      }
      if (hours <= h) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }
}
