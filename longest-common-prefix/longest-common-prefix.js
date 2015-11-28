var longestCommonPrefix = function(strs) {
    if (strs.length === 0) {
        return "";
    }
    
    var index = 0;
    var prefix = "";
    while (true) {
        var curr = strs[0][index];
        if (curr === undefined) {
            return prefix;
        }
        for (var i = 1; i < strs.length; i++) {
            if (strs[i][index] !== curr) {
                return prefix;
            }
        }
        index++;
        prefix += curr;
    }
};
