import sys
import os

# -----------------------------------
toogle_test: bool = True
# -----------------------------------


# Add the directory containing your package to sys.path -- Independent of the OS
package_dir = os.path.abspath(os.path.join(os.path.dirname(__file__), "../src"))
# print(package_dir)
sys.path.insert(0, package_dir)
# print(sys.path)

import array_and_hash_problem

test_instance = array_and_hash_problem.SolutionClass()


# Test case for Contain Duplicate problem
def test_contain_duplicate():
    """
    Generate test for contain duplicate problem
    """
    if toogle_test:

        assert (
            test_instance.contain_duplicate([1, 2, 3, 1]) == True
        ), "Test case 1 in contain duplicate failed"
        assert (
            test_instance.contain_duplicate([1, 2, 3, 4]) == False
        ), "Test case 2 in contain duplicate failed"
        assert (
            test_instance.contain_duplicate([1, 1, 1, 3, 3, 4, 3, 2, 4, 2]) == True
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
