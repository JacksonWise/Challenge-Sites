// https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=dictionaries-hashmaps

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {

        int totalPairs = 0;

        for(int mLeft = 0; mLeft < s.length() ; mLeft++ ){
            for( int mRight = mLeft+1; mRight <= s.length(); mRight++){

                String mainS = s.substring(mLeft, mRight);

                int mainLen = mRight - mLeft;

                for( int subLeft = mLeft+1; subLeft + mainLen <= s.length(); subLeft++){

                    String subS = s.substring(subLeft, subLeft + mainLen);

                    totalPairs += helperSub(mainS, subS);
                }
            }
        }

        return totalPairs;
    }

    static int helperSub(String mainS, String subS){

        int[] chars = new int[26];

        int letter = 0;
        
        for( int i = 0; i < mainS.length(); i++ ){
            letter = (int) mainS.charAt(i) - (int) 'a';
            chars[letter]++;
            letter = (int) subS.charAt(i) - (int) 'a';
            chars[letter]--;
        }

        for(int nums : chars){
            if(nums != 0)
                return 0;
        }

        //System.out.println("Confirmed ana mainS: " + mainS + ", subS: " + subS);

        return 1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
