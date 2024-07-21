class SolutionClass:
    def __init__(self):
        pass

    def contain_duplicate(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        return len(nums) != len(set(nums))
