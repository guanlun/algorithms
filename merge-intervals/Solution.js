var merge = function(intervals) {
    qsort(intervals, 0, intervals.length - 1);
    
    var i = 0;
    
    while (i < intervals.length - 1) {
        var curr = intervals[i];
        var next = intervals[i + 1];
        
        if (next.start <= curr.end) {
            if (next.end > curr.end) {
                curr.end = next.end;
            }
            intervals.splice(i + 1, 1);
        } else {
            i++;
        }
    }
    
    return intervals;
};

var qsort = function(intervals, left, right) {
    if (left >= right) {
        return;
    }
    
    var middle = (left + right) >> 1;
    var pivot = intervals[middle].start;
    var i = left,
        j = right;
        
    while (i < j) {
        while (intervals[i].start < pivot) {
            i++;
        }
        while (intervals[j].start > pivot) {
            j--;
        }
        
        if (i <= j) {
            var temp = intervals[i];
            intervals[i] = intervals[j];
            intervals[j] = temp;
            
            i++;
            j--;
        }
    }
    
    qsort(intervals, left, j);
    qsort(intervals, i, right);
};
