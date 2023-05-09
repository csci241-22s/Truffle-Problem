# Truffle-Problem
CSCI 405 Truffle Problem
Move through a 2d array given by a file
ex)
2 3 4 5
6 7 8 9
4 1 4 6
This program will find the maximum path through the truffle field that yields the most profit
assume that you can only move downward straight or diagonally one over
this program has a runtime of O(n*m)

Algorithm: run through full array and set values and parent-child relationships
each node contains a value, its current pathlength and a pointer to its parent and three children
work top down and when you set the three children also check each child's parent
if the current node has a higher path length than the child's old parent update the parent and pathlength
find bottom node with biggest pathlength and move up through ancestors to reconstruct path
