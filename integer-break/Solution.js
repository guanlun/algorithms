var integerBreak = function(n) {
    if (n === 2) {
        return 1;
    } else if (n === 3) {
        return 2;
    }
    
    var lookup = {
        2: 2,
        3: 3
    };
    
    for (var i = 4; i <= n; i++) {
        var max = 0;
        
        for (var sub = 2; sub <= 3; sub++) {
            var firstOp = lookup[sub];
            var secondOp = lookup[i - sub];
            
            var result = firstOp * secondOp;
            
            if (result > max) {
                max = result;
            }
        }
        
        lookup[i] = max;
    }
    
    return lookup[n];
};
