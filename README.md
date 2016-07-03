algorithms
=========
My solutions to the algorithm problems on LeetCode.

## Some Thoughts:
### Data Structures
For generating permutations without recursion, use a queue. In each iteration, get the length of the queue, pop them out one by one and addLast the generated values.

### Dynamic Programming
Consider carefully what the range is, e.g., for a coin count problem, we may need to start the index for 1 and use <= as the ending condition. Also, note that sometimes in DP the previous amount is invalid (e.g., knapsack), need to handle such invalid cases.

### Java
Do not misuse the LinkedList methods

### Misc
* Remember to assign the loop variable, do not mix up loop index and item in the list.
* Always remember to check when input is 0, 1 or null.
* When doing binary search, left should be set to mid + 1 if mid is less that the target value.
* Javascript and Java Strings are immutable, keep in mind that we cannot directly operate on strings. Need to build a char array and then join the characters.

