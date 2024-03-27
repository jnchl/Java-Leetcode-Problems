package org.example;

public class ZigZag {

    public static String convert(String s, int numRows) {

        StringBuilder[] charMatrix = new StringBuilder[numRows];

        for (int i = 0; i < numRows; i++) {
            charMatrix[i] = new StringBuilder();
        }

        int stringLength = s.length();
        int rowChange = numRows == 1 ? 1 : 2;

        int row = 0;
        int sIter = 0;

        outsideLoop:
        while (true){
            while (row < numRows){
                if (sIter < stringLength){
                    charMatrix[row].append(s.charAt(sIter));
                    sIter++;
                } else{
                    break outsideLoop;
                }
                row++;
            }

            row -= rowChange;

            while (row != 0){
                if (sIter < stringLength){
                    charMatrix[row].append(s.charAt(sIter));
                    sIter++;
                } else{
                    break outsideLoop;
                }
                row--;
            }
        }

        StringBuilder result = new StringBuilder();

        for (StringBuilder rowBuilder : charMatrix){
            result.append(rowBuilder);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";

        System.out.println(convert(s, 3));

    }
}
