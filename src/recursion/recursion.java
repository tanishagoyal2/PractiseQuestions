package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class recursion {

    public static void upperLowercase(String ssf,int k,int size,String string){
        //System.out.println(ssf+" for "+k);
        if(k==size){
            System.out.println(ssf);
            return ;
        }
        else{
            char ch=string.charAt(k);
            //System.out.println(ch+" found");
            if(Character.isDigit(ch)){
               // System.out.println("is didgit true");
                upperLowercase(ssf+ch,k+1,size,string);
            }
            else{
                upperLowercase(ssf+Character.toUpperCase(ch), k+1, size, string);
                upperLowercase(ssf+Character.toLowerCase(ch),k+1, size, string);
            }
        }
    }
    public static void solve(String ssf,int k,int n,String string){
        if(k==n){
            System.out.println(ssf);
            return ;
        }
        else{
            char ch=string.charAt(k);
            solve(ssf+Character.toLowerCase(ch),k+1,n,string);
            solve(ssf+Character.toUpperCase(ch),k+1,n,string);
        }
    }


    //parantheses
    public static void paran(List<String> li,int n,int open,int close,String ssf){
        if(close==n){
            li.add(ssf.toString());
            return ;
        }
        else{
            if(open<n){
                paran(li, n, open+1, close, ssf+"(");
            }
            if(close<open){
                paran(li, n, open, close+1, ssf+")");
            }
        }
    }
    //Find the number of ways that a given integer, , can be expressed as the sum of the  powers of unique, natural numbers.
    public static int findvalue(int x,int n,int k){
        int value=(int)(x-Math.pow(k,n));
        if(value==1){
            return 1;
        }
        if(value<0){
            return 0;
        }
        else{
            return findvalue(value, n, k+1)+findvalue(x, n, k+1);
        }
    }

    //using recursion
    public static boolean interleavingString(String s1,String s2,String s3,int m,int n,int k){
        if(m==-1 && n==-1 && k==-1){
            return true;
        }
        if(m>=0 && s1.charAt(m)==s3.charAt(k)){
           return interleavingString(s1, s2, s3, m-1, n, k-1); 
        }
        if(n>=0 && s2.charAt(n)==s3.charAt(k)){
            return interleavingString(s1, s2, s3, m, n-1, k-1);
        }
        return false;
    }

    //using dynamic approach
    public static void interleavingString(String s1,String s2,String s3){
        int m=s1.length();
        int n=s2.length();
        boolean dp[][]=new boolean[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0 && j==0){
                    dp[i][j]=true;
                    continue;
                }
                if(i==0){
                    dp[i][j]=dp[i][j-1]&& s2.charAt(j-1)==s3.charAt(i+j-1);
                    continue;
                }
                if(j==0){
                    dp[i][j]=dp[i-1][j]&& s1.charAt(i-1)==s3.charAt(i+j-1);
                    continue;
                }
                else{
                    dp[i][j]=(dp[i][j-1]&& s2.charAt(j-1)==s3.charAt(i+j-1))|| (dp[i-1][j] && s1.charAt(i-1)==s3.charAt(i+j-1));
                }
            }   
        }
        System.out.println(dp[m][n]);
    }

    //Given two integer arrays nums1 and nums2, return the maximum length of a subarray that appears in both arrays.
    public static void findLength(int nums1[],int nums2[]){
        int m=nums1.length;
        int n=nums2.length;
        int dp[][]=new int[m+1][n+1];
        int max=Integer.MIN_VALUE;
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }
                else{
                    if(nums1[i-1]==nums2[j-1]){
                        dp[i][j]=dp[i-1][j-1]+1;
                    }
                    max=Math.max(max, dp[i][j]);
                }
            }
        }
        System.out.println(max);
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int nums1[]={1,0,1,0,1};
        int nums2[]={0,1,1,1,1};
        findLength(nums1, nums2);
    }
    
}
