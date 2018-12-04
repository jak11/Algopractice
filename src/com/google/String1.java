package com.google;

public class String1 {
    public static String A, B, C;
    public static void main(String[] args) {
        /*System.out.println(isInterleave("B","e","Be"));
        System.out.println(isInterleave("eZCHXr0CgsB4O3TCDlitYI7kH38rEElI",
                "UhSQsB6CWAHE6zzphz5BIAHqSWIY24D","eUZCHhXr0SQsCgsB4O3B6TCWCDlAitYIHE7k6H3z8zrphz5EEBlIIAHqSWIY24D"));


        *//*s1 = "aabcc", s2 = "dbbca",
                When s3 = "aadbbcbcac", return true.
                When s3 = "aadbbbaccc", return false.*/
        A = "aabcc";
        B = "dbbca";
        C = "aadbbcbcac";
        isInterleaved(0,0,0);

        System.out.println(isInterleave("aabcc","dbbca","aadbbbaccc"));
    }

    public static int isInterleave(String A, String B, String C) {
        int targetLength=C.length();
        int aLength=A.length();
        int bLength=B.length();
        if(targetLength !=(aLength+bLength)) return 0;
        int currPosInA=0;
        int currePosInB=0;
        boolean aTrvs = false, btravs =false;


        int i=0;
        while (i < targetLength){

            while (currPosInA < aLength && C.charAt(i)==A.charAt(currPosInA) ){
                currPosInA++;
                aTrvs = true;
                i++;
            }
            while (currePosInB < bLength && C.charAt(i)==B.charAt(currePosInB)  ){
                currePosInB++;
                btravs =true;
                i++;
            }

            if(i == targetLength) {
                break;
            }

            if( !(btravs || aTrvs )){
                return 0;
            }

            aTrvs = false;btravs =false;

        }

        return 1;
    }

    public static int isInterleaved(int a, int b, int c){
        return 0;
    }
}
