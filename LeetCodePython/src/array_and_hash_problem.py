import collections


class SolutionClass:
    # This is to slove the problem when we must iterate through the data but keep track of the data "state" (like frequency, index, etc) or need
    def __init__(self):
        pass

    def contain_duplicate(self, nums: list[int]) -> bool:
        """
        https://leetcode.com/problems/contains-duplicate/
        Given an integer array nums, return true if any value appears at least twice in the array,
        and return false if every element is distinct.
        """
        return len(nums) != len(set(nums))

    def valid_anagram(self, s: str, t: str) -> bool:
        """
        https://leetcode.com/problems/valid-anagram/
        Given two strings s and t, return true if t is an anagram of s, and false otherwise.

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

    # two sum with annotation in the function parameter
    def two_sum(self, nums: list[int], target: int) -> list[int]:
        """
        https://leetcode.com/problems/two-sum/
        Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
        You may assume that each input would have exactly one solution, and you may not use the same element twice.
        You can return the answer in any order.
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

    def group_anagrams(self, strs: list[str]) -> list[list[str]]:
        """
        https://leetcode.com/problems/group-anagrams/
        Given an array of strings strs, group the anagrams together. You can return the answer in any order.
        An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

        Solution 1: Hashtable
        The ideal here is to use hashtable to sort the sort the string into character array and add it to the hashtable for futher reference. At the end, add every index of the hashtable to a list and return it.
        """
        hash_table = {}
        for s in strs:
            key = tuple(sorted(s))
            if key in hash_table:
                hash_table[key].append(s)
            else:
                hash_table[key] = [s]
        return list(hash_table.values())

    def top_k_frequent(self, nums: list[int], k: int) -> list[int]:
        """
        https://leetcode.com/problems/top-k-frequent-elements/
        Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

        Solutioin: Bucket sort
        Create a array with index as the frequency of the element and the value as the element itself (one freq can contain many element). Then iterate through the array from the end to get the k most frequent elements.
        """
        count = {}
        freq = [[] for i in range(len(nums) + 1)]
        for num in nums:
            count[num] = count.get(num, 0) + 1
        # freq array with index as the frequency
        # Alternative: This can be achived with data structure like heap (built-in heapq)
        for key, cnt in count.items():
            freq[cnt].append(key)
        res = []
        for i in range(len(freq) - 1, 0, -1):
            for num in freq[i]:
                res.append(num)
                if len(res) == k:
                    return res
        """
        More about heapq:
        A heap is a specialized tree-based data structure that satisfies the heap property: in a min-heap, for any given node, the parent node's value is less than or equal to its children's values.
        heapq.heappush(heap, item)  # Add item to heap
        heapq.heappop(heap)         # Remove and return smallest item
        heapq.heapify(list)         # Transform list into a heap
        Python's heapq is always a min-heap (smallest element at top). To use it as a max-heap, you can push the negative of the values.
        Operations like push and pop are O(log n)
        """

    def encode_and_decode():
        """
        271. Encode and Decode Strings
        https://neetcode.io/problems/string-encode-and-decode
        Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.
        Time: O(m) for encode and decode (m is length of array)
        Space: O(1) for both (since res does not count as extra space)
        Not Optimal: create a size array to store the length of each string
        Optimal: use length and # to separate each string (the order take from beginning)
        """

        def encode(self, strs: list[str]) -> str:
            res = ""
            for s in strs:
                res += str(len(s)) + "#" + s
                return res

        def decode(self, s: str) -> list[str]:
            res = []
            i = 0
            # Here data calculate on the fly
            while i < len(s):
                j = i
                while s[j] != "#":
                    j += 1
                length = int(s[i:j])
                i = j + 1
                j = i + length
                res.append(s[i:j])
                i = j

    def product_except_self(self, nums: list[int]) -> list[int]:
        """
        238. Product of Array Except Self - Medium
        https://leetcode.com/problems/product-of-array-except-self/
        Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
        The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
        You must write an algorithm that runs in O(n) time and without using the division operation.
        """

        # The ideal is go to the left and then calculate the result which is product of right of current element by remember the last product then add to current index continue to mul
        # Do the same for right side come to left
        res = [1] * len(nums)
        prefix = 1
        for i in range(len(nums)):
            res[i] = prefix
            prefix *= nums[i]
        postfix = 1
        for i in range(len(nums) - 1, -1, -1):
            res[i] *= postfix
            postfix *= nums[i]
        return res

    def valid_sudoku(self, board: list[list[str]]) -> bool:
        """
        36. Valid Sudoku - Medium
        https://leetcode.com/problems/valid-sudoku/
        Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
        Each row must contain the digits 1-9 without repetition.
        Each column must contain the digits 1-9 without repetition.
        Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
        """

        # Check the row, column should be straight forward. For the square, we can use the formula (r//3, c//3) to get the index of the square
        # defaultdict is a subclass of the built-in dict class. Automatically initializes a set for new keys, avoiding the need for explicit initialization.
        cols = collections.defaultdict(set)
        rows = collections.defaultdict(set)
        squares = collections.defaultdict(set)
        for r in range(9):
            for c in range(9):
                if board[r][c] == ".":
                    continue
                if (
                    board[r][c] in rows[r]
                    or board[r][c] in cols[c]
                    # In Python, dictionary keys can be any immutable type, such as a tuple
                    or board[r][c] in squares[(r // 3, c // 3)]
                ):
                    return False
                cols[c].add(board[r][c])
                rows[r].add(board[r][c])
                squares[(r // 3, c // 3)].add(board[r][c])
        return True
        # Complexity: time is O(n^2) where n is the size of the board and space is O(n^2) for 3 hash table to store each row and column and square
        """
        There also solution with bitmasking
        Every row and Column can be represented as a 9-bit number (1 to 9). If a number is present in the row, then set the corresponding bit to 1. 
        If the number is already present, then the AND operation will return a non-zero value, which means the number is repeated.
        Shifts 1 to the left by val places, creating a bitmask for the digit val + 1
        1 << 4 results in 00010000 (representing the digit 5).
        Bit OR add the digit to bitmask since two are uniqure
        Since this is Bitmap space for each of 3 is O(n)
        """

    def longest_consecutive(self, nums: list[int]) -> int:
        """
        128. Longest Consecutive Sequence - Medium
        https://leetcode.com/problems/longest-consecutive-sequence/
        Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
        You must write an algorithm that runs in O(n) time.
        """
        # Frist personal thougth: hashmap to store the latest element of the sequence and then check the previous if it avaiable
        # Turn out, to slove the kind of solution every sequence is begin with a number which previous of consecutive not in the list, now we will compare how numset work in python
        numSet = set(nums)
        longest = 0
        for n in nums:
            # check if it's start of a sequence
            if (n - 1) not in numSet:
                length = 1
                while (n + length) in numSet:
                    length += 1
                longest = max(length, longest)
        return longest
        """
        # Set lookup - O(1)
        my_set = {1, 2, 3, 4, 5}
        3 in my_set  # Very fast!

        # List lookup - O(n)
        my_list = [1, 2, 3, 4, 5]
        3 in my_list  # Has to check each element
        This O(1) complexity is possible because sets in Python are implemented using hash tables. When you add an element to a set:

        Python computes the element's hash value
        Uses this hash to determine where to store the element in memory
        When checking if an element exists, it just needs to:

        Compute the hash
        Look at that specific memory location
        Another solution would be use hashmap
        """
        # We only need to consider when new element come (not in list) (check it if left and right continue sequence)    yes then
        # update only the latest of the sequence from two end (mp[num - mp[num - 1]] = mp[num] and mp[num + mp[num + 1]] = mp[num]) is to the lenght of the sequence
        # If one of two end not in the list, then that is 0 (not create a new element - which only create when we assign value to it)
        # mp = defaultdict(int)
        # res = 0

        # for num in nums:
        #     if not mp[num]:
        #         mp[num] = mp[num - 1] + mp[num + 1] + 1
        #         mp[num - mp[num - 1]] = mp[num]
        #         mp[num + mp[num + 1]] = mp[num]
        #         res = max(res, mp[num])
        # return res
        # Runtime: 179 ms, faster than 40.07% of Python3 online submissions for Longest Consecutive Sequence.
        # Memory Usage: 40.8 MB, less than 6.93% of Python3 online submissions for Longest Consecutive Sequence.
