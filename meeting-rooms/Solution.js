var canAttendMeetings = function(intervals) {
    if (intervals.length === 0) {
        return true;
    }
    
    qsort(intervals, 0, intervals.length - 1);
    
    for (var i = 1; i < intervals.length; i++) {
        if (intervals[i].start < intervals[i - 1].end) {
            return false;
        }
    }
    
    return true;
};

var qsort = function(intervals, begin, end) {
    if (begin >= end) {
        return;
    }

    var middle = (begin + end) >> 1;
    var pivot = intervals[middle].start;
    var i = begin, j = end;
    
    while (i < j) {
        while (intervals[i].start < pivot) {
            i++;
        }
        
        while (intervals[j].start > pivot) {
            j--;
        }
        
        if (i <= j) {
            swap(intervals, i, j);
            i++;
            j--;
        }
    }
    
    qsort(intervals, begin, j);
    qsort(intervals, i, end);
};

var swap = function(intervals, i1, i2) {
    var temp = intervals[i1];
    intervals[i1] = intervals[i2];
    intervals[i2] = temp;
};
