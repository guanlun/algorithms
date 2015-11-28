function kth(arr, k, from, to) {
    var pivot = arr[to];
    var left = from;
    var right = to - 1;
    var temp;

    while (true) {
        while (arr[left] >= pivot && left < to) {
            left++;
        }

        while (arr[right] <= pivot && right >= 0) {
            right--;
        }
        
        if (left >= right) {
            break;
        }

        if (left < right) {
            temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }
    }

    temp = arr[left];
    arr[left] = pivot;
    arr[to] = temp;

    if (left == k - 1) { // found
        return arr[left];
    } else if (left > k - 1) {
        return kth(arr, k, from, left - 1);
    } else {
        return kth(arr, k, left + 1, to);
    }
}

var findKthLargest = function(nums, k) {
    return kth(nums, k, 0, nums.length - 1);
};
