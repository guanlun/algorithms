function processData(input) {
    var lines = input.split('\n');
    
    var w1 = lines[0];
    var w2 = lines[1];
    
    var result = [];
    
    // Init the first row / col with 0s in indicate any string does not have common child with an empty string
    for (var row = 0; row <= w2.length; row++) {
        result.push([0]);
    }
    
    for (var col = 1; col <= w2.length; col++) {
        result[0].push(0);
    }
    
    for (var row = 1; row <= w2.length; row++) {
        for (var col = 1; col <= w1.length; col++) {
            var c1 = w1[col - 1];
            var c2 = w2[row - 1];
            
            var leftResult = result[row][col - 1],
                topResult = result[row - 1][col],
                topLeftResult = result[row - 1][col - 1];
            
            if (c1 === c2) {
                topLeftResult += 1;
            }
            
            result[row][col] = Math.max(topLeftResult, Math.max(leftResult, topResult));
        }
    }
    
    console.log(result[w2.length][w1.length]);
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
