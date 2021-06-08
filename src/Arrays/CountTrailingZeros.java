package Arrays;

import java.math.BigInteger;
import java.util.Scanner;

public class CountTrailingZeros{


    public static void swastik(int n){
        int mid=n/2;
        System.out.println(mid);
        for(int i=0;i<n;i++){
            if(i==mid){
                for(int j=0;j<n;j++){
                    System.out.print("*");
                }
            }
            else if(i>=0 && i<=mid){
                for(int j=0;j<n;j++){
                    if(j==0 || j>=mid && j<n && i==0){
                        System.out.print("*");
                    }
                    else if(j==0 || j==mid ){
                        System.out.print("*");
                    }
                    else {
                        System.out.print(" ");
                    }
                }
            }
            else {
                for(int j=0;j<n;j++){
                    if(j==mid || j<=mid && j>=0 && i==n){
                        System.out.print("*");
                    }
                    else if(j== mid || j==n-1){
                        System.out.print("*");
                    }
                    else {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }

    }
//count the no of trailing zeroes in a factorial of a no,
     public static void solve(int n){
         BigInteger fact=new BigInteger("1");
         for(int i=2;i<=n;i++){
             fact=fact.multiply(BigInteger.valueOf(i));
         }
         int count=0;
         while(fact!=BigInteger.valueOf(0)){
            if(fact.mod(BigInteger.valueOf(10))==BigInteger.valueOf(0)){
                count++;
            }
            else{
                break;
            }
            fact=fact.divide(BigInteger.valueOf(10));
         }
         System.out.println(count);
     }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        swastik(n);
    }
}