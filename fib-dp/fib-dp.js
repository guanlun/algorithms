var n = 11;

var solutions = {
    1: 1,
    2: 1
};

for (var i = 3; i < n; i++) {
    solutions[i] = solutions[i - 1] + solutions[i - 2];
}

console.log(solutions[i - 1]);
