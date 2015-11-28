var compareVersion = function(version1, version2) {
    var v1 = version1.split('.');
    var v2 = version2.split('.');
    
    var len = Math.max(v1.length, v2.length);
    for (var i = 0; i < len; i++) {
        var n1 = parseInt(v1[i] || 0),
            n2 = parseInt(v2[i] || 0);
            
        if (n1 > n2) {
            return 1;
        } else if (n1 < n2) {
            return -1;
        }
    }
    
    return 0;
};
