var input = [5,2,8,6,3,6,9,7];

var solution = [];
for (var i = 0; i < input.length; i++) {
    solution.push(1);
}

for (var i = 1; i < input.length; i++) {
    var value = input[i];

    for (var j = 0; j < i; j++) {
        var prev = input[j];
        var len;
        if (value > prev) {
            len = solution[j] + 1;
        } else {
            len = 1;
        }

        if (len > solution[i]) {
            solution[i] = solution[j] + 1;
        }
    }
}

console.log(solution);
