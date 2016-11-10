var lengthLongestPath = function(input) {
    var lines = input.split('\n');

    var depthLookup = {};

    var maxDepth = 0;

    for (var i = 0; i < lines.length; i++) {
        var line = lines[i];
        var depth = 0;
        while (line[depth] === '\t') {
            depth++;
        }

        if (depth === 0) {
            depthLookup[depth] = line.length;
        } else {
            depthLookup[depth] = depthLookup[depth - 1] + line.length + 1 - depth;
        }

        if (line.indexOf('.') !== -1 && depthLookup[depth] > maxDepth) {
            maxDepth = depthLookup[depth];
        }
    }

    return maxDepth;
};
