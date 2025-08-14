package com.ilianxin.learn.hackerrank;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here

        if ( arr == null || arr.size() != 5 ) {
            System.out.println("0 0");
            return;
        }

        Collections.sort(arr);

        Long min = arr.stream().limit(4).mapToLong(Integer::longValue).sum();
        Long max = arr.stream().skip(1).mapToLong(Integer::longValue).sum();

        System.out.println(min + " " + max) ;
    }

}

public class MiniMaxSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}
