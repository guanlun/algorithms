var _ = require('lodash');

function processData(input) {
    var lines = input.split('\n');
    
    var numInputs = parseInt(lines[0]);
    
    var kids = [];
    
    for (var i = 1; i <= numInputs; i++) {
        var line = lines[i];
        var rating = parseInt(lines[i]);
        
        kids.push(rating);
    }
    
    var results = [];
    
    results[0] = 1;
    
    for (var i = 1; i < numInputs; i++) {
        if (kids[i] > kids[i - 1]) {
            results[i] = results[i - 1] + 1;
        } else {
            results[i] = 1;
        }
    }
    
    for (var i = numInputs - 2; i >= 0; i--) {
        if (kids[i] > kids[i + 1]) {
            results[i] = Math.max(results[i], results[i + 1] + 1);
        }
    }
    
    console.log(_.sum(results));
} 

process.stdin.resume();
process.stdin.setEncoding("ascii");
_input = "";
process.stdin.on("data", function (input) {
    _input += input;
});

process.stdin.on("end", function () {
   processData(_input);
});
