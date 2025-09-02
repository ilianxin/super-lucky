package com.ilianxin.learn.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class ResultsuperReducedString {

    /*
     * Complete the 'superReducedString' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String superReducedString(String s) {
        // Write your code here

        if ( s == null || s.length() ==0) {
            return "Empty String";
        }

        Stack<Character> stack = new Stack<>();

        for ( char c : s.toCharArray()) {
            if ( !stack.isEmpty() && stack.peek() == c ) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        if ( stack.isEmpty() ) {
            return "Empty String";
        }

        StringBuilder sb = new StringBuilder();

        while ( !stack.isEmpty() ) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();



    }

}

public class SuperReducedString {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = ResultsuperReducedString.superReducedString(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
