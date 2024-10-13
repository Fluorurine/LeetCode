package main

import (
	"testing"

	"github.com/stretchr/testify/assert"

	"fluorurine.com/solution/arrayandhash"
)

func TestAdd(t *testing.T) {
	// Create a new assert object
	assert := assert.New(t)

	// Test case 1
	result := arrayandhash.Add(2, 3)
	assert.Equal(5, result, "Test Add case 1 failed")

	// Test case 2
	result = arrayandhash.Add(3, 4)
	assert.Equal(7, result, "Test Add case 2 failed")
}

// func TestSub(t *testing.T) {
// 	if arrayandhash.Sub(3, 2) != 1 {
// 		t.Errorf("Test Sub case 1 failed")
// 	}
// 	if arrayandhash.Sub(4, 3) != 1 {
// 		t.Errorf("Test Sub case 2 failed")
// 	}
// }
