class SolutionClass:
    def __init__(self):
        pass

    def contain_duplicate(self, nums):
        """
        https://leetcode.com/problems/contains-duplicate/
        Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
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
        """

        """
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
