/* (C)2024 */
package com.fluorurine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class StackSolution {
  public boolean isValid(String s) {
    // 20. Valid Parentheses - Easy
    // https://leetcode.com/problems/valid-parentheses/
    if (s.length() % 2 != 0) {
      return false;
    }
    char[] stack = new char[s.length()];
    int top = -1;
    for (char c : s.toCharArray()) {
      if (c == '(' || c == '[' || c == '{') {
        stack[++top] = c;
      } else if (top == -1) {
        return false;
      } else if (c == ')' && stack[top--] != '(') {
        return false;
      } else if (c == ']' && stack[top--] != '[') {
        return false;
      } else if (c == '}' && stack[top--] != '{') {
        return false;
      }
    }
    return top == -1;
  }

  public int evalRPN(String[] tokens) {

    // 150. Evaluate Reverse Polish Notation - Medium
    // https://leetcode.com/problems/evaluate-reverse-polish-notation/
    Stack<Integer> stack = new Stack<>();
    for (String c : tokens) {
      if (c.equals("+")) {
        stack.push(stack.pop() + stack.pop());
      } else if (c.equals("-")) {
        int a = stack.pop();
        int b = stack.pop();
        stack.push(b - a);
      } else if (c.equals("*")) {
        stack.push(stack.pop() * stack.pop());
      } else if (c.equals("/")) {
        int a = stack.pop();
        int b = stack.pop();
        stack.push(b / a);
      } else {
        stack.push(Integer.parseInt(c));
      }
    }
    return stack.pop();
  }

  public int[] dailyTemperatures(int[] temperatures) {
    // 739. Daily Temperatures - Medium
    // https://leetcode.com/problems/daily-temperatures/
    int n = temperatures.length;
    int[] res = new int[n];
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < n; i++) {
      while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
        int index = stack.pop();
        res[index] = i - index;
      }
      stack.push(i);
    }
    return res;
    // public int[] dailyTemperatures(int[] temperatures) {
    // int n = temperatures.length;
    // int[] res = new int[n];

    // for (int i = n - 2; i >= 0; i--) {
    // int j = i + 1;
    // while (j < n && temperatures[j] <= temperatures[i]) {
    // if (res[j] == 0) {
    // j = n;
    // break;
    // }
    // j += res[j];
    // }

    // if (j < n) {
    // res[i] = j - i;
    // }
    // }
    // return res;
    // }
  }

  public List<String> generateParenthesis(int n) {
    // 22. Generate Parentheses - Medium
    // https://leetcode.com/problems/generate-parentheses/
    if (n == 0) {
      return new ArrayList<>();
    }

    List<List<String>> res = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      res.add(new ArrayList<>());
    }
    res.get(0).add("");

    for (int k = 0; k <= n; k++) {
      for (int i = 0; i < k; i++) {
        for (String left : res.get(i)) {
          for (String right : res.get(k - i - 1)) {
            res.get(k).add("(" + left + ")" + right);
          }
        }
      }
    }

    return res.get(n);
  }

  public int carFleet(int target, int[] position, int[] speed) {
    // 853. Car Fleet - Medium
    // https://leetcode.com/problems/car-fleet/
    int n = position.length;
    if (n == 0) {
      return 0;
    }
    int[][] cars = new int[n][2];
    for (int i = 0; i < n; i++) {
      cars[i][0] = position[i];
      cars[i][1] = speed[i];
    }
    Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));
    int count = 1;
    double time = (double) (target - cars[0][0]) / cars[0][1];
    for (int i = 1; i < n; i++) {
      double t = (double) (target - cars[i][0]) / cars[i][1];
      if (t > time) {
        count++;
        time = t;
      }
    }
    return count;
  }

  public int largestRectangleArea(int[] heights) {
    int maxArea = 0;
    Stack<int[]> stack = new Stack<>(); // pair: (index, height)

    for (int i = 0; i < heights.length; i++) {
      int start = i;
      while (!stack.isEmpty() && stack.peek()[1] > heights[i]) {
        int[] top = stack.pop();
        int index = top[0];
        int height = top[1];
        maxArea = Math.max(maxArea, height * (i - index));
        start = index;
      }
      stack.push(new int[] { start, heights[i] });
    }

    for (int[] pair : stack) {
      int index = pair[0];
      int height = pair[1];
      maxArea = Math.max(maxArea, height * (heights.length - index));
    }
    return maxArea;
  }
}
