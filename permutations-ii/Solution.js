/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permuteUnique = function(nums) {
    var results = [];
    
    nums.sort();
    
    var visited = [];
    for (var i = 0; i < nums.length; i++) {
        visited.push(false);
    }
    
    recur(results, [], nums, visited);
    
    return results;
};

var recur = function(results, currPerm, nums, visited) {
    if (currPerm.length === nums.length) {
        results.push(currPerm.slice(0));
        return;
    }
    
    for (var i = 0; i < nums.length; i++) {
        if (visited[i]) {
            continue;
        }

        if ((i > 0) && (nums[i] === nums[i - 1]) && (visited[i - 1])) {
            continue;
        }
        
        visited[i] = true;
        currPerm.push(nums[i]);
        recur(results, currPerm, nums, visited);
        currPerm.pop();
        visited[i] = false;
    }
}
