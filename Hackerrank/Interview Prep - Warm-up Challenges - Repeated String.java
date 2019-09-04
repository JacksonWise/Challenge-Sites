// https://www.hackerrank.com/challenges/repeated-string/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=warmup

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {

        long sLen = (long) s.length();

        long div = n / sLen;
        long mod = n % sLen;

        long numA = 0;

        long remaining = n > sLen? sLen : mod;

        for(int i = 0; i < remaining; i++ )
            if(s.charAt(i) == 'a')
                numA++;

        numA *= div > 0 ? div : 1;
        
        if( div > 0 && mod > 0){
            remaining = n - (sLen * div);
            for(int i = 0; i < remaining; i++ )
                if(s.charAt(i) == 'a')
                    numA++;
        }

        return numA;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
