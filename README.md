algorithms
=========
My solutions to the algorithm problems on LeetCode.

## Some Thoughts:
### Data Structures
For generating permutations without recursion, use a queue. In each iteration, get the length of the queue, pop them out one by one and addLast the generated values.

### Dynamic Programming
Consider carefully what the range is, e.g., for a coin count problem, we may need to start the index for 1 and use <= as the ending condition. Also, note that sometimes in DP the previous amount is invalid (e.g., knapsack), need to handle such invalid cases.

### Generating combinations (77)
Could use the recursive backtracking approach by passing `results` down:
* Starting from the 1st element, call 2 recursive functions (one with new element added and the other one without).
* When there are enough elements, add the current result to the `results` array and stop.
* When there are not enough elements (`total number n - current number + current result length + 1 <= target number of elements in result`), only call the recursive function with the current element added.
* Think about `n - curr + 1 + len <= k` in this way: at position `curr`, we still have `n - curr + 1` elements to visit. If `k` is larger than the number of elements we have then there's no way we could reach `k` elements.

### Generating permutations with duplicated items (47)
Use DFS, maintaining the visited items and avoid continuing on duplication.
* To avoid inserting duplicated item, sort the input array first so that we could easily check whether the current number has been processed.
* Maintain an array of visited items, if the previous item is equal to the current item and the previous item has been visited, stop. This is to eliminating every permutation except the one going through the duplicated items from the back to the front.
* Example: `[1, 1, 1, 2]`, when going deep into the recursion, unless we are going through `[1, 1, 1]` from the back to the front, we will eventually come into the case where the previous item is visited before, thus an invalid case.

### Java
Do not misuse the LinkedList methods

### Misc
* Remember to assign the loop variable, do not mix up loop index and item in the list.
* Always remember to check when input is 0, 1 or null.
* When doing binary search, left should be set to mid + 1 if mid is less that the target value.
* Javascript and Java Strings are immutable, keep in mind that we cannot directly operate on strings. Need to build a char array and then join the characters.

