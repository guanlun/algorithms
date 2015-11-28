var isAnagram = function(s, t) {
    var sLength = s.length,
        tLength = t.length;
    if (sLength != tLength) {
        return false;
    }
    
    var sDict = {},
        tDict = {};
    
    for (var i = 0; i < sLength; i++) {
        var c = s[i];
        if (sDict[c]) {
            sDict[c] += 1;
        } else {
            sDict[c] = 1;
        }
    }
    
    for (i = 0; i < tLength; i++) {
        c = t[i];
        if (tDict[c]) {
            tDict[c] += 1;
        } else {
            tDict[c] = 1;
        }
    }
    
    for (i in sDict) {
        if (sDict[i] !== tDict[i]) {
            return false;
        }
    }
    
    return true;
};
