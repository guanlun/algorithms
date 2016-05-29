var convert = function(s, numRows) {
    if (numRows === 1) {
        return s;
    }
    
    var gap = (numRows - 1) * 2;
    var len = s.length;
    
    var result = [];
    
    for (var row = 0; row < numRows; row++) {
        for (var i = row; i < len; i += gap) {
            result.push(s[i]);
            
            if ((row !== 0) && (row !== numRows - 1)) {
                var secondIndex = i + gap - row - row;
                
                if (secondIndex < len) {
                    result.push(s[secondIndex]);
                }
            }
        }
    }
    
    return result.join('');
};
