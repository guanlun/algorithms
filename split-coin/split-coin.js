var values = [1, 2, 5, 10];

var total = 34;

var solutions = {
    0: 0
};

for (var curr = 1; curr <= total; curr++) {
    for (var j in values) {
        var value = values[j];
        if (curr - value < 0) {
            continue;
        }
        var num = 1 + solutions[curr - value];
        if (solutions[curr] === undefined) {
            solutions[curr] = num;
        } else if (num < solutions[curr]) {
            solutions[curr] = num;
        }
    }
}

console.log(solutions);
