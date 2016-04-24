var reverseVowels = function(s) {
    if (s === '') {
        return '';
    }
    
    var front = 0;
    var back = s.length - 1;
    
    var charArr = s.split('');
    
    while (true) {
        while (front < charArr.length - 1 && !vowels[charArr[front]]) {
            front++;
        }
        
        while (back > 0 && !vowels[charArr[back]]) {
            back--;
        }
        
        if (front >= back) {
            break;
        }
        
        var temp = charArr[front];
        charArr[front] = charArr[back];
        charArr[back] = temp;
        
        front++;
        back--;
    }
    
    return charArr.join('');
};

var vowels = {
    'a': true,
    'e': true,
    'i': true,
    'o': true,
    'u': true,
    'A': true,
    'E': true,
    'I': true,
    'O': true,
    'U': true
};
