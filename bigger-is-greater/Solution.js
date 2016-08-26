function processData(input) {
    var lines = input.split('\n');
    
    var numCases = parseInt(lines[0]);
    
    for (var i = 1; i < numCases + 1; i++) {
        solveCase(lines[i]);
    }
}

function solveCase(str) {
    var lastIncreasingIndex = -1;
    
    for (var i = str.length - 1; i >= 0; i--) {
        if (str.charCodeAt(i) < str.charCodeAt(i + 1)) {
            lastIncreasingIndex = i;
            break;
        }
    }
    
    if (lastIncreasingIndex === -1) {
        console.log('no answer');
        return;
    }
    
    var pivot = str.charCodeAt(lastIncreasingIndex);
    var minLargerIndex = lastIncreasingIndex + 1;
    var minItemLarger = str.charCodeAt(minLargerIndex);

    for (var i = lastIncreasingIndex + 1; i < str.length; i++) {
        var charCode = str.charCodeAt(i);
        
        if (charCode > pivot && charCode <= minItemLarger) {
            minItemLarger = charCode;
            minLargerIndex = i;
        }
    }
    
    var arr = str.split('');
    swap(arr, lastIncreasingIndex, minLargerIndex);
    
    var left = lastIncreasingIndex + 1;
    var right = arr.length - 1;
    
    while (left < right) {
        swap(arr, left, right);
        left++;
        right--;
    }
    
    console.log(arr.join(''));
}

function swap(arr, i1, i2) {
    var temp = arr[i1];
    arr[i1] = arr[i2];
    arr[i2] = temp;
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

