var isUgly = function(num) {
    if (num < 1) {
        return false;
    }

    var factors = [2, 3, 5];
    
    for (var i in factors) {
        var factor = factors[i];
        while (num % factor === 0) {
            num = num / factor;
        }
    }
    
    for (var i = 5; i < num / 30 + 1; i += 2) {
        if (num % i === 0) {
            return false;
        }
    }
    
    return true;
};

console.log(isUgly(905391974));

