// https://www.hackerrank.com/challenges/new-year-chaos/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=arrays

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {

        // Set to 0 moves and build an ascending int array
        int numMoves = 0;
        int[] arr = new int[q.length];

        for(int i = 0; i < arr.length; i++)
            arr[i] = i+1;

        boolean chaotic = false;

        int qPos = 0;
        int arrPos = 0;

        for( ; qPos < q.length; qPos++){
            
            arrPos = qPos;

            // Positions match, no moves here
            if(arr[arrPos] == q[qPos])
                continue;
            
            // Find where this person moved from
            while( arr[arrPos] != q[qPos] ){
                arrPos++;
            }

            int numBribes = arrPos - qPos;
            numMoves += numBribes;

            if( numBribes > 2 ){
                chaotic = true;
                break;
            }

            // Move the person forward
            while( arr[qPos] != q[qPos] ){
                int temp = arr[arrPos-1];
                arr[arrPos-1] = arr[arrPos];
                arr[arrPos] = temp;
                arrPos--;
            }
        }

        if(chaotic){
            System.out.println("Too chaotic");
        }
        else{
            System.out.println(numMoves);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
