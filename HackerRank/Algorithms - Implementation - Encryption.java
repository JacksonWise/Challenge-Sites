// https://www.hackerrank.com/challenges/encryption/problem

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the encryption function below.
    static String encryption(String s) {

        String[] words = s.split(" ");

        StringBuilder totalString = new StringBuilder();

        for( String parts : words )
            totalString.append(parts);

        int chars = totalString.length();

        int row = (int) Math.sqrt(chars);

        int col = row;

        if( (col * row) < chars )
            col++;

        if( (col * row) < chars )
            row++;

        String[] output = new String[row];

        for( String str : output)
            System.out.print( str + " " );

        int pos = 0;

        for(int i = 0; i < row; i++){

            StringBuilder sub = new StringBuilder();

            for( int k = 0; k < col; k++ ){
                sub.append(totalString.charAt(pos));
                pos++;
            }

            output[i] = sub.toString();
        }

        if( col != row ){

            StringBuilder sub = new StringBuilder();

            while( pos < chars ){
                sub.append(totalString.charAt(pos));
                pos++;
            }

            output[row-1] = sub.toString();
        }

        int lastRowChars = chars % col;

        pos = 0;

        int nextCol = 0, nextRow = 0;

        StringBuilder encrypted = new StringBuilder();

        while( pos < chars ){

            nextRow = 0;
            
            for( ; nextRow < row-1; nextRow++ ){
                encrypted.append(output[nextRow].charAt(nextCol));
            }
            if( lastRowChars > 0){
                encrypted.append(output[nextRow].charAt(nextCol));
                lastRowChars--;
            }
            
            pos++;
            nextCol++;

            if( pos != chars )
                encrypted.append(" ");
        }

        return encrypted.toString();

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
