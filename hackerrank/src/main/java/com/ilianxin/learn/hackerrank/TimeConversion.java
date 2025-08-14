package com.ilianxin.learn.hackerrank;

import java.io.*;

import static java.util.stream.Collectors.joining;

class TimeConversionResult {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        // Write your code here

        if ( s == null || s.length() ==0) {
            return null;
        }

        String hours = "";

        boolean isPM = s.toUpperCase().contains("PM");

        String hour = s.substring(0,2);

        String left = s.substring(2,8);

        // System.out.println(hour +"_" + left);

        if ("12".equals(hour)) {
            hours = isPM? "12" : "00";
        } else {
            int targetHour = Integer.parseInt(hour) + 12;
            hours = isPM? String.valueOf(targetHour) : hour;
        }


        return hours.concat(left);

    }

}

public class TimeConversion {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = TimeConversionResult.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
