var l = function(s) {
    var lookup = {};
    var cutoff = 0;
    var currLen = 0;
    var maxLen = 0;
    
    for (var i in s) {
    // for (var i = 0; i < s.length; i++) {
        var char = s[i];
        console.log(lookup[char]);
        if (lookup[char] && (lookup[char] >= cutoff)) {
            currLen = i - lookup[char];
            cutoff = lookup[char];
        } else {
            currLen += 1;
        }
        
        lookup[char] = i;
        
        if (currLen > maxLen) {
            maxLen = currLen;
        }
    }
    
    return maxLen;
};

console.log(l("aa"));
