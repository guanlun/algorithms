public class ZigzagIterator {
    private int listIndex;
    private int itemIndex;

    private List<List<Integer>> lists;
    private boolean[] finished;
    private int numLists;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.lists = new ArrayList<List<Integer>>();
        this.lists.add(v1);
        this.lists.add(v2);

        this.numLists = this.lists.size();

        this.listIndex = v1.isEmpty() ? 1 : 0;
        this.itemIndex = 0;
    }

    public int next() {
        List<Integer> currList = lists.get(listIndex);

        if (itemIndex >= currList.size()) {
            return -1;
        }

        int retVal = currList.get(itemIndex);

        int iter = 0;

        while (iter <= numLists) {
            listIndex = (listIndex + 1) % numLists;

            if (listIndex == 0) {
                itemIndex++;
            }

            List<Integer> nextList = lists.get(listIndex);

            if (itemIndex < nextList.size()) {
                return retVal;
            }

            iter++;
        }

        return retVal;
    }

    public boolean hasNext() {
        List<Integer> currList = lists.get(listIndex);

        return (itemIndex < currList.size());
    }
}
