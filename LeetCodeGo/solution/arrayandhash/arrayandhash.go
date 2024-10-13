package arrayandhash

import "fmt"

func TestHelloString() {
	fmt.Println("Hello, World from Test Hello String!")
}
func Add(a, b int) int {
	return a + b
}
func Sub(a, b int) int {
	return a - b
}
func twoSum(nums []int, target int) []int {
	// Create a map to store the value and its index
	numMap := make(map[int]int)

	// Iterate through the nums slice
	for i, num := range nums {
			// Calculate the complement
			complement := target - num

			// Check if the complement exists in the map
			if index, found := numMap[complement]; found {
					return []int{index, i} // Return the indices of the two numbers
			}

			// Store the number and its index in the map
			numMap[num] = i
	}

	// Return an empty slice if no solution is found
	return []int{}
}