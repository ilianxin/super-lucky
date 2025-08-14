package com.ilianxin.learn.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class PlusMinus {


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.plusMinus(arr);

        bufferedReader.close();
    }

    class Result {

        /*
         * Complete the 'plusMinus' function below.
         *
         * The function accepts INTEGER_ARRAY arr as parameter.
         */

        public static void plusMinus(List<Integer> arr) {
            // Write your code here

            BigDecimal positive = new BigDecimal(0).setScale(6);
            BigDecimal negative = new BigDecimal(0).setScale(6);
            BigDecimal zero = new BigDecimal(0).setScale(6);


            if (arr == null || arr.size() == 0) {
                System.out.println(positive);
                System.out.println(negative);
                System.out.println(zero);
                return;
            }

            BigDecimal length = new BigDecimal(arr.size());

            positive =
                    new BigDecimal(arr.stream().filter(a -> a>0).count()) ;
            negative =
                    new BigDecimal(arr.stream().filter(a -> a<0).count()) ;
            zero =
                    new BigDecimal(arr.stream().filter(a -> a==0).count()) ;


            System.out.println(positive.divide(length, 6, RoundingMode.HALF_UP));
            System.out.println(negative.divide(length, 6, RoundingMode.HALF_UP));
            System.out.println(zero.divide(length, 6, RoundingMode.HALF_UP));

        }

    }
}
