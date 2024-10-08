class SolutionClass:

    def __init__(self):
        pass

    def contain_duplicate(self, nums):
        """
        https://leetcode.com/problems/contains-duplicate/
        Given an integer array nums, return true if any value appears at least twice in the array,
        and return false if every element is distinct.
        :type nums: List[int]
        :rtype: bool
        """
        return len(nums) != len(set(nums))

    def valid_anagram(self, s, t):
        """
        https://leetcode.com/problems/valid-anagram/
        Given two strings s and t, return true if t is an anagram of s, and false otherwise.
        :type s: str
        :type t: str
        :rtype: bool

        Another solution 1 : Hashtable - ord mean return the unicode point of a character
        count = [0] * 26

            # Count the frequency of characters in string s
            for x in s:
                count[ord(x) - ord('a')] += 1

            # Decrement the frequency of characters in string t
            for x in t:
                count[ord(x) - ord('a')] -= 1

            # Check if any character has non-zero frequency
            for val in count:
                if val != 0:
                    return False

            return True
        """
        return sorted(s) == sorted(t)

    def two_sum(self, nums, target):
        """
        https://leetcode.com/problems/two-sum/
        Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
        You may assume that each input would have exactly one solution, and you may not use the same element twice.
        You can return the answer in any order.
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        # Solution 1: Brute force
        # for i in range(len(nums)):
        #     for j in range(i + 1, len(nums)):
        #         if nums[i] + nums[j] == target:
        #             return [i, j]
        # return []

        # Solution 2: Hashtable
        hash_table = {}
        for i in range(len(nums)):
            if nums[i] in hash_table:
                return [hash_table[nums[i]], i]
            hash_table[target - nums[i]] = i
        return []
