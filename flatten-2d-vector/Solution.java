public class Vector2D implements Iterator<Integer> {
    private int listIndex;
    
    private int itemIndex;
    
    private List<List<Integer>> vec2d;

    public Vector2D(List<List<Integer>> vec2d) {
        this.vec2d = vec2d;
        
        listIndex = 0;
        itemIndex = 0;
    }

    @Override
    public Integer next() {
        List<Integer> list;
        
        do {
            if (listIndex >= this.vec2d.size()) {
                return null;
            }
            
            list = this.vec2d.get(listIndex);
            
            if (itemIndex >= list.size()) {
                listIndex++;
                itemIndex = 0;
                continue;
            }
            
            int val = list.get(itemIndex);
            
            itemIndex++;
            
            return val;
        } while (true);
    }

    @Override
    public boolean hasNext() {
        List<Integer> list;
        
        do {
            if (listIndex >= this.vec2d.size()) {
                return false;
            }
            
            list = this.vec2d.get(listIndex);
            
            if (itemIndex >= list.size()) {
                listIndex++;
                itemIndex = 0;
                continue;
            }
            
            return true;
        } while (true);
    }
}
