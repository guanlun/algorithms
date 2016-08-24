/**
 * @param {string} s
 * @return {number}
 */
var romanToInt = function(s) {
    var lookup = {
        I: 1,
        V: 5,
        X: 10,
        L: 50,
        C: 100,
        D: 500,
        M: 1000,
    };
    
    var repeatingNumeralSum;
    var lastChar;
    
    var values = [];
    
    for (var i = 0; i < s.length; i++) {
        var char = s[i];
        var val = lookup[char];
        
        if (char === lastChar) {
            repeatingNumeralSum += val;
        } else {
            repeatingNumeralSum = val;
            
            values.push({
                unit: val,
                sum: repeatingNumeralSum,
            });
        }
    }
    
    var totalSum = 0;
    
    for (var i = 0; i < values.length - 1; i++) {
        var unitSum = values[i].sum;
        if (values[i].unit < values[i + 1].unit) {
            totalSum -= unitSum;
        } else {
            totalSum += unitSum;
        }
    }
    
    totalSum += values[values.length - 1].sum;
    
    return totalSum;
};
