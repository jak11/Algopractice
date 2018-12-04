import java.io.*;
class SOlution1 {
    public static void main(String args[]) {
        System.out.println("Hello world - Java!");
        //getNthMagicNUmber(4);
        System.out.println(getNthNUmberRec(2,0,0,0,0,1));

        for (int i = 0; i < 4; i++) {

        }
    }

    double getNUmber(int i, int j, int k, int l){
        return -1;
    }

    private static double getNthNUmberRec(int n, int i, int j, int k, int l, int start){
        System.out.println(i + "- " + j + "- "+ k + " -" + l);
        double number = Math.pow(2,i)*Math.pow(3,j)*Math.pow(5,k)*Math.pow(7,l);
        if(n == start){
            return number;
        } else if(start < n && i < n && j < n && k < n && l < n){
            double a1 = getNthNUmberRec(n,  i+1, j, k, l,start);
            double a2 = getNthNUmberRec(n,  i, j+1, k, l,start);
            double a3 = getNthNUmberRec(n,  i, j, k+1, l,start);
            double a4 = getNthNUmberRec(n,  i, j, k, l+1,start);
            start++;
            return Math.min(a1, Math.min(a2,Math.min(a3,a4)));
        } else {
            return -1;
        }
    }

    private static int getNthMagicNUmber(int n){
        double[][] powerstore = new double[4][n +1];
        powerstore[0][0] = 2;
        powerstore[1][0] = 3;
        powerstore[2][0] = 5;
        powerstore[3][0] = 7;
        for(int i=1; i <= n; i++){
            powerstore[0][i] = Math.pow(2, i - 1);
            powerstore[1][i] = Math.pow(3, i - 1);
            powerstore[2][i] = Math.pow(5, i - 1);
            powerstore[3][i] = Math.pow(7, i - 1);
        }

        System.out.println(powerstore);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(powerstore[i][j] + "  ");
            }
            System.out.println(" ");
        }

        int c =0;
        int i = 1, j= 1, k =1, l =1;
        while (c <= n ){
            double number = powerstore[0][i] * powerstore[1][j] * powerstore[2][k]* powerstore[3][l];
            System.out.println("number-->" + number);
            c++;

            double min = powerstore[0][i+1];

            if(powerstore[1][j+1] <  min){
                j++;
                min = powerstore[1][j+1];
            } else
            if(powerstore[2][k+1] <  min){
                k++;
                min = powerstore[2][k+1];
            } else
            if(powerstore[3][l+1] <  min){
                l++;
                min = powerstore[3][l+1];
            } else {
                i++;
            }

            //int minIndex = findMininumNextNumber(powerstore, i, j, k , l);
        }

        return -1;
    }

    private static int findMininumNextNumber(double[][] powerstore, int i, int j, int k, int l) {
        double min = powerstore[0][i+1];
        int minindex = i;
        for (int m = 1; m <= 3; m++) {
            if(powerstore[m][j+1] <  min){
                minindex = j;
                min = powerstore[m][j+1];
            }
            if(powerstore[m][k+1] <  min){
                minindex = k;
                min = powerstore[m][k+1];
            }
            if(powerstore[m][l+1] <  min){
                minindex = k;
                min = powerstore[m][l+1];
            }
        }

        return minindex;
    }
}


/**
 magic number : any number in the form 2^a * 3^b * 5^c * 7^d, where a,b,c,d >= 0
 */