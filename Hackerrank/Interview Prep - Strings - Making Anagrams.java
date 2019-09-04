// https://www.hackerrank.com/challenges/ctci-making-anagrams/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=strings

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {

        // Keep "score" of differing characters
        int[] alph = new int[26];

        int charVal = 0;
        int total = 0;

        // Get ascii values from 'a' == 0
        for(int i = 0; i < a.length(); i++){
            charVal = (int) a.charAt(i) - (int) 'a';
            alph[charVal]++;
        }

        for(int i = 0; i < b.length(); i++){
            charVal = (int) b.charAt(i) - (int) 'a';
            alph[charVal]--;
        }

        for(int points : alph){
            total += (points > 0 ? points : -points);
        }

        return total;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
