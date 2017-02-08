public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        String result = "";
        
        for (String s : strs) {
            result += "" + s.length() + ' ' + s + ' ';
        }
        
        return result;
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new ArrayList<String>();
        
        String buffer = "";
        boolean readingLength = true;
        int currLen = 0;
        int targetLen = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (readingLength) {
                if (c == ' ') {
                    readingLength = false;
                    targetLen = Integer.parseInt(buffer);
                    currLen = 0;
                    buffer = "";
                } else {
                    buffer += c;
                }
            } else {
                if (currLen == targetLen) {
                    result.add(buffer);
                    
                    readingLength = true;
                    buffer = "";
                } else {
                    buffer += c;
                    currLen++;
                }
            }
        }
        
        return result;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
