
algorithms
=========
My solutions to the algorithm problems.

## What to clarify before jumping into coding:
### General
* Do I need to handle invalid inputs?

### Array
* Does the array contain duplicate items?

### Generating numbers
* Do we allow 0 in the first digit?

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

### Combination Sum (39, 40, 216)
Use DFS, maintaining the current items in the combination.
* End recursion when the sum is equal to (or larger than) the target value.
* Remember to make a copy of the current array when adding to the final results, since the current array keeps mutating.
* To avoid duplicated items, skip items that equal to its previous item.
* Example, target is `5` and input is `[1, 1, 2, 2, 2]`, at the first `2`, we enter the DFS with `[2, 2]` remaining and do not skip the next `2`. However, after coming back from that DFS, moving on to the second `2`, there's no point doing DFS again at it since we've already included that in our previous search.

### Generating permutations with duplicated items (47)
Use DFS, maintaining the visited items and avoid continuing on duplication.
* To avoid inserting duplicated item, sort the input array first so that we could easily check whether the current number has been processed.
* Maintain an array of visited items, if the previous item is equal to the current item and the previous item has been visited, stop. This is to eliminating every permutation except the one going through the duplicated items from the back to the front.
* Example: `[1, 1, 1, 2]`, when going deep into the recursion, unless we are going through `[1, 1, 1]` from the back to the front, we will eventually come into the case where the previous item is visited before, thus an invalid case.

### Dealing with binary tree sub problems (250)
For problems that requires both subtrees and the relation between the parent and child nodes to meet some criteria, use the following procedure to shorten the code:
* If node is null, consider as "meeting the criteria".
* If one of two subtrees does not meet, negative result.
* If left is not null and left - parent relation does not meet, negative.
* Right side version of last step.
* Now, there can only be: left is null and right meets, right is null and left meets, left & right are both null, positive result.

### Next permutation
* First find the last item greater than the item after it, then find the minimum item that is after and larger than it.
* Swap the last increasing index and the minimum larger index.
* Reverse everything after the last increasing index.
  Note that when comparing the minimum item after `lastIncreasingIndex` that's larger than it, use `>=` instead of `>`, since we'd like to get the last item.

### Word Ladder
* Do not iterator through the whole set of words each time. Try to create possible new words from the current word and check if that new word is in the list.

### Prefix tree (Trie)
* Each node does not hold a value, instead, it holds a boolean value indicating whether it's an end point (whole word), and a map from a character to one of its children.
* If we have a small alphabet, we could replace the map with an array of a fixed number of elements (equal to the alphabet size).

### Java
* Do not misuse the LinkedList methods
* The foreach loop is a syntax sugar for an iterator, however we do not have access to the iterator when usingthe foreach loop. The only way to remove items while iterating is to use an `Iterator` explicitly.

### Misc
* Remember to assign the loop variable, do not mix up loop index and item in the list.
* Always remember to check when input is 0, 1 or null.
* When doing binary search, left should be set to mid + 1 if mid is less that the target value.
* Javascript and Java Strings are immutable, keep in mind that we cannot directly operate on strings. Need to build a char array and then join the characters.
* Use a queue for BFS. When we need to track the depth, create a local variable `n` for the size at the beginning of each iteration and remove `n` items from the queue in each iteration.
