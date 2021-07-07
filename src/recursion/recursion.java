package recursion;

import java.util.Arrays;
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
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int res=findvalue(800,2,1);
        System.out.println(res);
    }
    
}
