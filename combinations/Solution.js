// With recursive backtracking
var combine = function(n, k) {
    var results = [];
    
    recur(results, [], n, k, 1);
    
    return results;
};

var recur = function(results, prevResult, n, k, currNum) {
    var len = prevResult.length;
    
    if (len === k) {
        results.push(prevResult);
        return;
    }
    
    if (n - currNum + 1 + len > k) {
        var copyPrev = prevResult.slice(0);
        recur(results, copyPrev, n, k, currNum + 1);
    }
    
    var withNew = prevResult.slice(0);
    withNew.push(currNum);
    recur(results, withNew, n, k, currNum + 1);
};

// With interations
var combine = function(n, k) {
    var results = [ [] ];
    
    for (var i = 1; i <= n; i++) {
        var lastResultLen = results.length;
        
        for (var lastResultIdx = 0; lastResultIdx < lastResultLen; lastResultIdx++) {
            var lastResult = results.shift();
            
            if (lastResult.length === k) {
                results.push(lastResult);
                continue;
            }

            if (n - i + lastResult.length + 1 > k) {
                results.push(lastResult.slice(0));
            }
            
            var resultWithElement = lastResult.slice(0);
            resultWithElement.push(i);
            
            results.push(resultWithElement);
        }
    }
    
    return results;
};
