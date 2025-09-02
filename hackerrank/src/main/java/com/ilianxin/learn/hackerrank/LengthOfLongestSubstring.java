package com.ilianxin.learn.hackerrank;

import java.util.ArrayList;
import java.util.List;

class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int maxLength = 0;
        List<Character> currentSubstring = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (currentSubstring.contains(c)) {
                // Remove characters until we remove the duplicate
                while (currentSubstring.contains(c)) {
                    currentSubstring.remove(0);
                }
            }
            currentSubstring.add(c);
            maxLength = Math.max(maxLength, currentSubstring.size());
        }


        return maxLength;
    }
}