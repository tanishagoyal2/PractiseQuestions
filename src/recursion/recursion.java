package recursion;

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
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String string=sc.nextLine();
        upperLowercase("", 0, string.length(), string);
    }
    
}
