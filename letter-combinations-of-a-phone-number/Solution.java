public class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Character, Character[]> digitToSequenceMap = new HashMap<Character, Character[]>();
        digitToSequenceMap.put('1', new Character[]{});
        digitToSequenceMap.put('2', new Character[]{'a', 'b', 'c'});
        digitToSequenceMap.put('3', new Character[]{'d', 'e', 'f'});
        digitToSequenceMap.put('4', new Character[]{'g', 'h', 'i'});
        digitToSequenceMap.put('5', new Character[]{'j', 'k', 'l'});
        digitToSequenceMap.put('6', new Character[]{'m', 'n', 'o'});
        digitToSequenceMap.put('7', new Character[]{'p', 'q', 'r', 's'});
        digitToSequenceMap.put('8', new Character[]{'t', 'u', 'v'});
        digitToSequenceMap.put('9', new Character[]{'w', 'x', 'y', 'z'});
        digitToSequenceMap.put('0', new Character[]{});
        
        LinkedList<String> results = new LinkedList<String>();
        
        if (digits.length() == 0) {
            return results;
        }
        
        results.add("");
        
        int digitsLength = digits.length();
        for (int digitIndex = 0; digitIndex < digitsLength; digitIndex++) {
            char digit = digits.charAt(digitIndex);
            Character[] letters = digitToSequenceMap.get(digit);
            int lettersLength = letters.length;
            
            if (lettersLength == 0) {
                continue;
            }
            
            int resultLength = results.size();
            
            for (int resultIndex = 0; resultIndex < resultLength; resultIndex++) {
                String prefix = results.remove();
                
                for (int letterIndex = 0; letterIndex < lettersLength; letterIndex++) {
                    String newCombination = prefix + letters[letterIndex];
                    results.addLast(newCombination);
                }
            }
        }
        
        return results;
    }
}
