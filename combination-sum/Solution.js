/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
var combinationSum = function(candidates, target) {
    var results = [];
    
    recur(results, candidates, target, 0, [], 0);
    
    return results;
};

var recur = function(results, candidates, target, currSum, currComb, startFrom) {
    if (currSum > target) {
        return;
    } else if (currSum === target) {
        results.push(currComb.slice(0));
        return;
    }
    
    for (var i = startFrom; i < candidates.length; i++) {
        var item = candidates[i];
        
        currComb.push(item);
        recur(results, candidates, target, currSum + item, currComb, i);
        currComb.pop();
    }
};
