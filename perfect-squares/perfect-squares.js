var numSquares = function(n) {
    var memory = {
        0: 0
    };
    
    for (var i = 0; i <= n; i++) {
        var min = i;
        var root = 1;
        while (root * root <= i) {
            var ref = i - root * root;
            var num = memory[ref] + 1;
            if (num < min) {
                min = num;
            }
            root++;
        }
        
        memory[i] = min;
    }
    
    return memory[n];
};
