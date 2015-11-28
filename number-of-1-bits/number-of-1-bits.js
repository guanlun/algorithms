var hammingWeight = function(n) {
    var curr = 4294967296;
    var count = 0;
    
    while (curr >= 1) {
        if (n - curr >= 0) {
            n -= curr;
            count++;
        }
        curr /= 2;
    }
    
    return count;
};
