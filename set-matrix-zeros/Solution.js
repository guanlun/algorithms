/**
 * @param {number[][]} matrix
 * @return {void} Do not return anything, modify matrix in-place instead.
 */
var setZeroes = function(matrix) {
    let max = -Number.MAX_VALUE;
    
    const height = matrix.length;
    const width = matrix[0].length;
    
    for (let i = 0; i < height; i++) {
        for (let j = 0; j < width; j++) {
            const val = matrix[i][j];
            
            if (val > max) {
                max = val;
            }
        }
    }
    
    const placeholder = max + 1;
    
    for (let i = 0; i < height; i++) {
        for (let j = 0; j < width; j++) {
            const val = matrix[i][j];
            
            if (val === 0) {
                for (let jj = 0; jj < width; jj++) {
                    if (matrix[i][jj] !== 0) {
                        matrix[i][jj] = placeholder;
                    }
                }
                
                for (let ii = 0; ii < height; ii++) {
                    if (matrix[ii][j] !== 0) {
                        matrix[ii][j] = placeholder;
                    }
                }
            }
        }
    }
    
    for (let i = 0; i < height; i++) {
        for (let j = 0; j < width; j++) {
            const val = matrix[i][j];
            if (val === placeholder) {
                matrix[i][j] = 0;
            }   
        }
    }
};
