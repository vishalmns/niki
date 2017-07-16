package com.company;
import java.io.*;
import java.util.*;

// No to consecutive zeros in a string
// with help of permuttion and combination and trend
// 1 = 1,0 = 2
// 2 = 11,10,01 = 3
// 3 = 111,110,101,011,010 = 5
// 4 = 1111,1110,1101,1011,0111,1010,0101,0110 = 8
// 5 = 11111,11110,11101,11011,10111,01111,11010,10101,01011,10110,01101,01110,01010 = 13

// by looking at the trend we can say it is fib series



public class Main {

    static long mod = 1000000007;
    public static void main(String[] args) {
	// write your code here
        Scanner scan = new Scanner(System.in);
        int testCase = scan.nextInt();
        while(testCase--!=0) {
            long n = scan.nextLong();
            //    long ansRec  = fibRecursion(n); // by recurion by not suitable for large number
	    //	System.out.println(ansRec);
          //      long ansLoop = fibLoop(n);    // suitable for large numbers
	//	System.out.println(ansLoop);
            long ans = fib(n + 2); // this gives result in log(n)
            System.out.println(ans);

        }
        }


    public static long fibRecursion(long n) {
        if(n==1)
            return 2;
        else if(n==2)
            return 3;
        else
            return (fibRecursion(n-1) + fibRecursion(n-2)) % mod;
    }

    public static long fibLoop(long n) {
        long ansOne = 2;
        long ansTwo = 3;
        if(n==1)
             return ansOne;
        if(n==2)
            return ansTwo;
        for(long i =3; i<= n ; i++) {
            long temp = (ansOne + ansTwo) % mod;
            ansOne = ansTwo;
            ansTwo =temp;
        }
        return  ansTwo;
    }
    static long fib(long n)
    {
        long F[][] = new long[][]{{1,1},{1,0}};
        if (n == 0)
            return 0;
        power(F, n-1);

        return F[0][0];
    }

    static void multiply(long F[][], long M[][])
    {
        long x =  (F[0][0]*M[0][0] + F[0][1]*M[1][0]) % mod;
        long y =  (F[0][0]*M[0][1] + F[0][1]*M[1][1]) % mod;
        long z =  (F[1][0]*M[0][0] + F[1][1]*M[1][0]) % mod;
        long w =  (F[1][0]*M[0][1] + F[1][1]*M[1][1]) % mod;

        F[0][0] = x;
        F[0][1] = y;
        F[1][0] = z;
        F[1][1] = w;
    }

    static void power(long F[][], long n)
    {
        if( n == 0 || n == 1)
            return;
        long M[][] = new long[][]{{1,1},{1,0}};

        power(F, n/2);
        multiply(F, F);

        if (n%2 != 0)
            multiply(F, M);
    }

}
