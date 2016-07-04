/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
var combinationSum2 = function(candidates, target) {
    var results = [];
    
    candidates.sort();
    
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
        if ((i > startFrom) && (candidates[i] === candidates[i - 1])) {
            continue;
        }

        var item = candidates[i];
        
        currComb.push(item);
        recur(results, candidates, target, currSum + item, currComb, i + 1);
        currComb.pop();
    }
};
