function insert(n, m, i, j) {
    var mask = ~((-1 >>> (31 - (j - i))) << i);

    return (n & mask) | (m << i);
}

var n = Math.pow(2, 10) + 1;
var m = 19;

var result = insert(n, m, 2, 6);

console.log(n.toString(2));
console.log(m.toString(2));
console.log(result.toString(2));
