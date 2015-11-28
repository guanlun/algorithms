var lengthOfLongestSubstring = function(s) {
    var lookup = {};
    var cutoff = 0;
    var currLen = 0;
    var maxLen = 0;
    
    for (var i = 0; i < s.length; i++) {
        var char = s[i];
        if (lookup[char] !== undefined && lookup[char] >= cutoff) {
            // found duplicate
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
