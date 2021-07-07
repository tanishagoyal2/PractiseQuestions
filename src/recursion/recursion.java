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
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        List<String> res=new ArrayList<String>();
        paran(res, 3, 0, 0, "");
        System.out.println(res);
    }
    
}
