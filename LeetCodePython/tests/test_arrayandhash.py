"""
This file contains the test cases for the array and hash problems
"""

import pytest

# -----------------------------------
toogle_test: bool = True
# -----------------------------------

from array_and_hash_problem import SolutionClass

if toogle_test:
    test_instance = SolutionClass()


def test_contain_duplicate():
    """
    Generate test for contain duplicate problem
    """
    if toogle_test:

        assert (
            test_instance.contain_duplicate([1, 2, 3, 1]) is True
        ), "Test case 1 in contain duplicate failed"
        assert (
            test_instance.contain_duplicate([1, 2, 3, 4]) is False
        ), "Test case 2 in contain duplicate failed"
        assert (
            test_instance.contain_duplicate([1, 1, 1, 3, 3, 4, 3, 2, 4, 2]) is True
        ), "Test case 3 in contain duplicate failed"


def test_two_sum():
    """
    Generate test for two sum problem
    """
    if toogle_test:
        assert test_instance.two_sum([2, 7, 11, 15], 9) == [
            0,
            1,
        ], "Test case 1 in two sum failed"
        assert test_instance.two_sum([3, 2, 4], 6) == [
            1,
            2,
        ], "Test case 2 in two sum failed"
        assert test_instance.two_sum([3, 3], 6) == [
            0,
            1,
        ], "Test case 3 in two sum failed"


def test_group_anagrams():
    """
    Generate test for group anagrams problem
    """
    if toogle_test:
        assert test_instance.group_anagrams(
            ["eat", "tea", "tan", "ate", "nat", "bat"]
        ) == [
            ["eat", "tea", "ate"],
            ["tan", "nat"],
            ["bat"],
        ], "Test case 1 in group anagrams failed"

        assert test_instance.group_anagrams([""]) == [
            [""]
        ], "Test case 2 in group anagrams failed"
        assert test_instance.group_anagrams(["a"]) == [
            ["a"]
        ], "Test case 3 in group anagrams failed"


def test_top_k_frequent():
    """
    Generate test for top k frequent problem
    """
    if toogle_test:
        assert test_instance.top_k_frequent([1, 1, 1, 2, 2, 3], 2) == [
            1,
            2,
        ], "Test case 1 in top k frequent failed"
        assert test_instance.top_k_frequent([1], 1) == [
            1
        ], "Test case 2 in top k frequent failed"
        assert test_instance.top_k_frequent([1, 2, 2, 3, 3, 3], 2) in (
            [2, 3],
            [3, 2],
        ), "Test case 3 in top k frequent failed"
        assert test_instance.top_k_frequent([1, 2, 2, 3, 3, 3], 3) == [
            3,
            2,
            1,
        ], "Test case 4 in top k frequent failed"


# import sys
# import os


# Add the directory containing your package to sys.path -- Independent of the OS
# package_dir = os.path.abspath(os.path.join(os.path.dirname(__file__), "../src"))
# print(package_dir)
# sys.path.insert(0, package_dir)

# print(sys.path)
