// https://www.hackerrank.com/challenges/ctci-ransom-note/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=dictionaries-hashmaps

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {

        // Check if there are even enough words to make the note
        if( note.length > magazine.length){
            System.out.print("No");
            return;
        }

        // Build a HashMap from magazine words    
        HashMap<String, Integer> hMap = new HashMap<String, Integer>();

        for( String words : magazine ){
            Integer num = (Integer) hMap.get(words);
            
            if( num == null ){
                hMap.put(words, 1);
            }
            else{
                hMap.put(words, ++num);
            }
        }

        // Check if all note words are in the magazine
        for( String words : note ){
            Integer num = (Integer) hMap.get(words);

            if( num == null || num < 1 ){

                System.out.print("No");
                 return;
            }

            hMap.put(words, --num );
        }

        // No problems? Success!
        System.out.print("Yes");
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
