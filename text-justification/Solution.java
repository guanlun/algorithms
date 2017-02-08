public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<String>();
        
        List<String> currLineWords = new ArrayList<String>();
        
        int currWidth = 0;
        
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int len = word.length();
            
            if (currWidth + len > maxWidth) {
                // Not enough space, move to next line
                String line = this.createLine(currLineWords, maxWidth, currWidth - 1, false);
                
                result.add(line);
                
                currLineWords.clear();
                currLineWords.add(word);
                currWidth = len + 1;
                
            } else {
                // Enough space, fit in current line
                currLineWords.add(word);
                
                currWidth += len + 1;
            }
        }
        
        // Handle last line
        if (currLineWords.size() > 0) {
            String lastLine = this.createLine(currLineWords, maxWidth, currWidth - 1, true);
            result.add(lastLine);
        }
        
        return result;
    }
    
    private String createLine(List<String> currLineWords, int maxWidth, int currWidth, boolean isLastLine) {
        int currLineWordCount = currLineWords.size();

        int extraSpaces = maxWidth - currWidth + currLineWordCount - 1;
        
        String line = "";
                
        if (isLastLine || currLineWordCount == 1) {
            for (int wordIdx = 0; wordIdx < currLineWordCount - 1; wordIdx++) {
                String wordToInsert = currLineWords.get(wordIdx);
                line += wordToInsert + ' ';
            }
            
            if (currLineWordCount > 0) {
                line += currLineWords.get(currLineWordCount - 1);
            }
            
            String spaces = "";
            
            for (int spaceIdx = 0; spaceIdx < maxWidth - line.length(); spaceIdx++) {
                spaces += ' ';
            }
            
            line += spaces;
            
        } else {
            int insertPlaces = currLineWordCount - 1;
            
            int baseSpaceNum = extraSpaces / insertPlaces;
            int extraSpaceNum = extraSpaces % insertPlaces;
            
            for (int wordIdx = 0; wordIdx < currLineWordCount - 1; wordIdx++) {
                String wordToInsert = currLineWords.get(wordIdx);
                
                String spaces = "";
                for (int spaceIdx = 0; spaceIdx < baseSpaceNum; spaceIdx++) {
                    spaces += ' ';
                }
                
                if (wordIdx < extraSpaceNum) {
                    spaces += ' ';
                }
                
                line += wordToInsert + spaces;
            }
            
            if (currLineWordCount > 0) {
                line += currLineWords.get(currLineWordCount - 1);
            }
        }
        
        return line;
    }
}
