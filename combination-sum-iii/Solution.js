/**
 * @param {number} k
 * @param {number} n
 * @return {number[][]}
 */
var combinationSum3 = function(k, n) {
    var results = [];
    recur(k, n, results, [], 0, 1);
    
    return results;
};

var recur = function(k, n, results, currComb, currSum, startFrom) {
    if (currComb.length === k) {
        if (currSum === n) {
            results.push(currComb.slice(0));
        }
        
        return;
    }
    
    for (var i = startFrom; i <= 9; i++) {
        currComb.push(i);
        recur(k, n, results, currComb, currSum + i, i + 1);
        currComb.pop();
    }
};
