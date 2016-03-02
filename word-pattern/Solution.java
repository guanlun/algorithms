public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] segments = str.split(" ");
        
        if (pattern.length() != segments.length) {
            return false;
        }
        
        HashMap<Character, String> lookup = new HashMap<Character, String>();
        HashMap<String, Character> reverseLookup = new HashMap<String, Character>();
        
        int patternLength = pattern.length();
        for (int i = 0; i < patternLength; i++) {
            char letter = pattern.charAt(i);
            String segment = segments[i];
            
            String mappedString = lookup.get(letter);
            if (mappedString != null) {
                if (!mappedString.equals(segment)) {
                    return false;
                }
            } else {
                lookup.put(letter, segment);
            }
            
            Character mappedLetter = reverseLookup.get(segment);
            if (mappedLetter != null) {
                if (mappedLetter != letter) {
                    return false;
                }
            } else {
                reverseLookup.put(segment, letter);
            }
        }
        
        return true;
    }
}
