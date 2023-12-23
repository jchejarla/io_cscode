package io.cscode.algorithms.arrays;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

    static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();

        List<StringBuilder> currentLine = new ArrayList<>();
        int currentLength = 0;
        for(String word : words) {

            if(currentLength + (currentLine.size()) + word.length() > maxWidth) {

                int totalSpaces = maxWidth - currentLength; // total spaces available

                int spacesDistro = totalSpaces / Math.max(1, currentLine.size() -1); // Math.max is to avoid divide by zero
                int remainingSpaces = totalSpaces % Math.max(1, currentLine.size() -1);

                // now add spaces at the end of strings
                for(int i=0; i<Math.max(1, currentLine.size()-1); i++) { // we don't need spaces for last word, but if there is only one word we need to
                    StringBuilder sb = currentLine.get(i);
                    for(int j=0; j<spacesDistro; j++) { // add required number of spaces
                        sb.append(" ");
                    }

                    // + add remainingSpaces in greedy fashion
                    if(remainingSpaces > 0) {
                        sb.append( " ");
                        remainingSpaces --;
                    }

                }

                String justifiedLine = String.join("",currentLine);
                result.add(justifiedLine);

                //reset below, once a line is justified
                currentLine.clear();
                currentLength = 0;
            }
            currentLine.add(new StringBuilder(word));
            currentLength+=word.length();

        }

        // add the last line here, since it may not have entered into if condition above
        if(!currentLine.isEmpty()) {
            String lastLine = String.join(" ", currentLine);
            int remainingSpaces = maxWidth - lastLine.length();
            result.add(lastLine + (" ".repeat(remainingSpaces)));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16));
        System.out.println(fullJustify(new String[]{"What","must","be","acknowledgment","shall","be"}, 16));
        System.out.println(fullJustify(new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"}, 20));

    }
}
