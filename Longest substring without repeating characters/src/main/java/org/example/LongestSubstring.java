package org.example;

import java.util.BitSet;

public class LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int stringLength = s.length();

        if (stringLength == 0 || stringLength == 1) {
            return stringLength;
        }

        int longestSubstringLength = 0;

        BitSet visited = new BitSet();

        int leftBound = 0;
        int rightBound = 0;

        while (rightBound < stringLength) {
            if (visited.get(s.charAt(rightBound))) {
                while (visited.get(s.charAt(rightBound))) {

                    visited.clear(s.charAt(leftBound));
                    leftBound++;
                }
            }

            visited.set(s.charAt(rightBound));
            longestSubstringLength = Math.max(longestSubstringLength, rightBound - leftBound + 1);
            rightBound++;
        }

        return longestSubstringLength;
    }


    public static void main(String[] args) {
        String testString = "abcabcbb";

        System.out.println(lengthOfLongestSubstring(testString));

    }
}
