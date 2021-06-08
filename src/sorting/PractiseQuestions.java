package sorting;
import java.util.*;
public class PractiseQuestions {

	public static void findNumberOfTriangles(int arr[], int n)
    {
        // code here
		int count=0;
        Arrays.sort(arr);
        // code here
        for(int i=n-1;i>0;i--){
           int l=0,r=i-1;
            while(l<r){
                if(arr[l]+arr[r]>arr[i]){
                    count+=r-1;
                    r--;
                }
                else{
                    l++;
                }
            }
        }
        System.out.println(count);
        
    }
    public static int factorial(int memo[],int n){
        if(n==0|| n==1){
            memo[n]=1;
        }
        else{
            if(memo[n]==-1){
            memo[n]=n*factorial(memo,n-1);
                
            }
        }
        return memo[n];
    }
	public static void main(String args[] ){
		int arr[]= {4,3,5,6,7};
		findNumberOfTriangles(arr,5);
	}
}
