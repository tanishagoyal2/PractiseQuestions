package dynamic;

import java.util.List;

public class LPS {
    //longest palindrome substring
    public static void LPS(String str){
        int n=str.length();
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++){
            dp[i][i]=1;
            for(int j=i;j<n;j++){
                if(str.charAt(i)==str.charAt(j)){
                    dp[i][j]=dp[i+1][j-1]+2;
                }
                else {
                    dp[i][j]=Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[0][n-1]);
    }
    //find the length of longest continues palindrome string
    static int resultstart=0;
    static int resultlength=0;
    public static void LPS2(String s){
        int n=s.length();
        if(n<2){
            System.out.println(s+" "+s.length());
            return ;
        }
        for(int i=0;i<n;i++){
            expandRange(s,i,i);//for odd length palindrome
            expandRange(s,i,i+1);//for even length palindrome
        }
        System.out.println(s.substring(resultstart, resultstart+resultlength));
    }
    public static void expandRange(String s,int start,int end){
        while(start>=0 && end<=s.length()-1 && s.charAt(start)==s.charAt(end)){
            start--;
            end++;
        }
        if(resultlength<end-start-1){
            resultstart=start+1;
            resultlength=end-start-1;
        }
        //System.out.println(s.substring(resultstart, resultstart+resultlength    ));
    }
    public static void shortestPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        String result="";
        while(i<j){
            if(s.charAt(i)==s.charAt(j)){
                result+=s.charAt(i);
                i++;
                j--;
            }
            else {
                result+=s.charAt(j);
                j--;
            }
        }
        result+=s.substring(j, s.length());
        System.out.println(result);
    }
    public static void main(String[] args) {
        String str="abcd";
        shortestPalindrome(str);
    }
    
}
