var isPalindrome = function(s) {
    var length = s.length;
    if (length === 0) {
        return true;
    }
    
    var left = 0,
        right = length - 1;
        
    while (true) {
        while (!isAlphaNumeric(s[left]) && (left < right)) {
            left++;
        }
        
        while (!isAlphaNumeric(s[right]) && (left < right)) {
            right--;
        }
        
        if (left >= right) {
            return true;
        }
        
        if (s[left].toLowerCase() != s[right].toLowerCase()) {
            return false;
        }
        
        left++;
        right--;
    }
};

function isAlphaNumeric(n) {
    if (n >= 'a' && n <= 'z') {
        return true;
    }
    
    if (n >= 'A' && n <= 'Z') {
        return true;
    }
    
    if (n >= '0' && n <= '9') {
        return true;
    }
    
    return false;
}
