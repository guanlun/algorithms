/**
 * @param {string} num1
 * @param {string} num2
 * @return {string}
 */
var multiply = function(num1, num2) {
    var results = [];
    var finalResults = [];
    var carry;
    
    for (var i = num2.length - 1; i >= 0; i--) {
        var result = [];
        
        for (var j = num2.length - 1; j > i; j--) {
            result.unshift(0);
        }
        
        carry = 0;
        var digit2 = num2[i];
        
        for (j = num1.length - 1; j >= 0; j--) {
            var digit1 = num1[j];
            
            var product = digit1 * digit2 + carry;
            
            result.unshift(product % 10);
            carry = Math.floor(product / 10);
        }
        
        if (carry !== 0) {
            result.unshift(carry);
        }
        
        results.push(result);
    }
    
    carry = 0;
    
    for (i = 0; i < results[results.length - 1].length; i++) {
        sum = carry;
        carry = 0;
        
        for (j = 0; j < results.length; j++) {
            result = results[j];
            
            var digitIndex = result.length - 1 - i;
            
            if (digitIndex >= 0) {
                sum += result[digitIndex];
            }
        }
        
        finalResults.unshift(sum % 10);
        carry = Math.floor(sum / 10);
    }
    
    if (carry !== 0) {
        finalResults.unshift(carry);
    }
    
    while ((finalResults[0] === 0) && (finalResults.length > 1)) {
        finalResults.shift();
    }
    
    return finalResults.join('');
};
