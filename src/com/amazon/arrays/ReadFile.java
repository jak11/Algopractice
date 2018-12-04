package com.amazon.arrays;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ReadFile
{
    public static void main(String[] args)
    {
        String str = "unicomp6.unicomp.net - - [01/Jul/1995:00:00:06 -0400] \"GET /shuttle/countdown/ HTTP/1.0\" 200 3985";
        String result = str.substring(str.indexOf("[") + 1, str.indexOf("]"));
        System.out.println(result.substring(0, result.indexOf("-")));
        System.out.println(result);
        ReadFile readFile = new ReadFile();
        readFile.getTimeStamp("input.txt");

    }

    public void getTimeStamp(String FILENAME){
        String regex = "^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$";
        HashSet<String> duplicateSet = new HashSet<>();
        HashSet<String> dulpicateList = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {

                String result = sCurrentLine.substring(sCurrentLine.indexOf("[") + 1, sCurrentLine.indexOf("]"));
                String dateObject =   result.substring(0, result.indexOf("-"));
                System.out.println(sCurrentLine);
                dateObject = dateObject.trim();
                if(!duplicateSet.add(dateObject)) {
                    dulpicateList.add(dateObject);
                }else {
                    duplicateSet.add(dateObject);
                }
                System.out.println("dateObject -->" + dateObject);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


        try (BufferedWriter bw = new BufferedWriter(new FileWriter("req_input.txt"))) {

            for (String s: dulpicateList
                 ) {
                bw.write(s);
                bw.newLine();
            }

        } catch (IOException e) {

            e.printStackTrace();

        }

    }
}
