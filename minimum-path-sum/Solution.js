var minPathSum = function(grid) {
    if ((grid.length === 0) || (grid[0].length === 0)) {
        return null;
    }
    
    var sums = [];
    
    var height = grid.length,
        width = grid[0].length;
    
    for (var i = 0; i < height; i++) {
        sums[i] = [];
    }
    
    for (i = 0; i < height; i++) {
        for (var j = 0; j < width; j++) {
            if (i === 0) {
                if (j === 0) {
                    sums[i][j] = grid[i][j];
                } else {
                    sums[i][j] = grid[i][j] + sums[i][j - 1];
                }
            } else {
                if (j === 0) {
                    sums[i][j] = grid[i][j] + sums[i - 1][j];
                } else {
                    sums[i][j] = grid[i][j] + Math.min(sums[i - 1][j], sums[i][j - 1]);
                }
            }
        }
    }
    
    return sums[height - 1][width - 1];
};
