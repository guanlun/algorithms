function processData(input) {
    var lines = input.split('\n');
    
    var numCases = parseInt(lines[0]);
    
    var lineIdx = 1;
    
    while (lineIdx < lines.length) {
        var numNodeEdgeLine = lines[lineIdx++];
        
        var segs = numNodeEdgeLine.split(' ');
        var numNode = parseInt(segs[0]);
        var numEdge = parseInt(segs[1]);
        
        var edges = [];
        
        for (var i = 0; i < numEdge; i++) {
            var edgeStr = lines[lineIdx];
            var edgeSegs = edgeStr.split(' ');
            edges.push([parseInt(edgeSegs[0]), parseInt(edgeSegs[1])]);

            lineIdx++;
        }
        
        solveCase(numNode, edges, parseInt(lines[lineIdx++]));
    }
} 

function solveCase(numNode, edges, startingNode) {
    var queue = [startingNode];
    
    var distance = 6;
    
    var lookup = {};
    var edgeVisited = {};
    
    while (queue.length !== 0) {
        var queueLength = queue.length;
        
        var newQueue = [];
        
        for (var elemIdx = 0; elemIdx < queueLength; elemIdx++) {
            var item = queue.shift();
            
            for (var i = 0; i < edges.length; i++) {
                if (edgeVisited[i]) {
                    continue;
                }
                
                var edge = edges[i];
                var distItem = -1;
                if (edge[0] === item) {
                    distItem = edge[1];
                } else if (edge[1] === item) {
                    distItem = edge[0];
                }
                
                if (distItem !== -1 && !lookup[distItem]) {
                    lookup[distItem] = distance;
                    newQueue.push(distItem);
                    
                    edgeVisited[i] = true;
                }
                
            }
        }
        
        distance += 6;
        queue = newQueue;
    }
    
    var result = [];
    
    for (var i = 1; i <= numNode; i++) {
        if (i === startingNode) {
            continue;
        }
        
        if (lookup[i]) {
            result.push(lookup[i]);
        } else {
            result.push(-1);
        }
    }
    
    console.log(result.join(' '));
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
