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

        depthLookup[depth] = {
            index: i,
        };

        if (depth === 0) {
            depthLookup[depth].len = line.length;
        } else {
            depthLookup[depth].len = depthLookup[depth - 1].len + line.length + 1 - depth;
        }

        if (line.indexOf('.') !== -1 && depthLookup[depth].len > maxDepth) {
            maxDepth = depthLookup[depth].len;
        }
    }

    return maxDepth;
};
