var permute = function(nums) {
    var results = [];
    
    for (var i = 0; i < nums.length; i++) {
        results.push([nums[i]]);
    }
    
    while (results[0].length !== nums.length) {
        var previousResult = results.shift();
        
        for (i = 0; i < nums.length; i++) {
            var number = nums[i];
            
            if (previousResult.indexOf(number) === -1) {
                var newResult = previousResult.slice(0);
                newResult.push(number);
                
                results.push(newResult);
            }
        }
    }
    
    return results;
};
