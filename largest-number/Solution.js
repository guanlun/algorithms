var largestNumber = function(nums) {
    var numStrings = [];
    
    for (var i = 0; i < nums.length; i++) {
        numStrings.push(nums[i].toString());
    }
    
    qsort(numStrings, 0, numStrings.length - 1);
    
    var result = numStrings.join('');
    
    while (result[0] === '0') {
        if (result.length === 1) {
            return result;
        }
        
        result = result.substring(1);
    }
    
    return result;
};

var qsort = function(numStrs, begin, end) {
    if (begin >= end) {
        return;
    }
    
    var middle = (begin + end) >> 1;
    var pivot = numStrs[middle];
    var i = begin,
        j = end;
    
    while (i < j) {
        while (compare(numStrs[i], pivot) > 0) {
            i++;
        }
        
        while (compare(numStrs[j], pivot) < 0) {
            j--;
        }
        
        if (i <= j) {
            var temp = numStrs[i];
            numStrs[i] = numStrs[j];
            numStrs[j] = temp;

            i++;
            j--;
        }
    }
    
    qsort(numStrs, begin, j);
    qsort(numStrs, i, end);
};

var compare = function(numStr1, numStr2) {
    var idx1 = 0,
        idx2 = 0,
        len1 = numStr1.length,
        len2 = numStr2.length;
        
    while (true) {
        if (numStr1[idx1] > numStr2[idx2]) {
            return 1;
        } else if (numStr1[idx1] < numStr2[idx2]) {
            return -1;
        } else {
            idx1 = (idx1 + 1) % len1;
            idx2 = (idx2 + 1) % len2;
            
            if ((idx1 === 0) && (idx2 === 0)) {
                return 0;
            }
        }
    }
};
