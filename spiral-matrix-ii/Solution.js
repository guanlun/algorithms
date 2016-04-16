var DIR_RIGHT = 0,
    DIR_DOWN = 1,
    DIR_LEFT = 2,
    DIR_UP = 3;

var generateMatrix = function(n) {
    if (n === 0) {
        return [];
    }

    var mtx = [];
    var i, j;
    
    for (i = 0; i < n; i++) {
        mtx.push([]);
        
        for (j = 0; j < n; j++) {
            mtx[i].push(0);
        }
    }
        
    var dir = DIR_RIGHT;
        pos = {
            x: 0,
            y: 0
        }
    
    var count = 1;
        
    while (true) {
        mtx[pos.y][pos.x] = count++;
        switch (dir) {
            case DIR_RIGHT:
                pos.x++;
                
                if ((pos.x === n) || (mtx[pos.y][pos.x] !== 0)) {
                    pos.x--;
                    pos.y++;
                    
                    dir = DIR_DOWN;
                }
                break;
            case DIR_DOWN:
                pos.y++;
                
                if ((pos.y === n) || (mtx[pos.y][pos.x] !== 0)) {
                    pos.y--;
                    pos.x--;
                    
                    dir = DIR_LEFT;
                }
                break;
            case DIR_LEFT:
                pos.x--;
                
                if ((pos.x === -1) || (mtx[pos.y][pos.x] !== 0)) {
                    pos.x++;
                    pos.y--;
                    
                    dir = DIR_UP;
                }
                break;
            case DIR_UP:
                pos.y--;
                
                if ((pos.y === -1) || (mtx[pos.y][pos.x] !== 0)) {
                    pos.y++;
                    pos.x++;
                    
                    dir = DIR_RIGHT;
                }
                break;
        }
        
        if (!mtx[pos.y] || mtx[pos.y][pos.x] !== 0) {
            break;
        }
    }
    
    return mtx;
};
