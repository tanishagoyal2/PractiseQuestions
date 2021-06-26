package Arrays;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;
public class ArrayQuestions extends Throwable{

	public static void count(int arr[],int p,int n) {
		int array[]=new int [n];
		Arrays.fill(array, 0);
			for(int i=0;i<p;i++) {
				array[arr[i]-1]++;
			}
			for(int i=0;i<n;i++) {
				arr[i]=array[i];
			}
			for(int i=0;i<n;i++) {
				System.out.print(arr[i]);
			}
	}
	public static int equilibriumPoint(long arr[], int n) {

        // Your code here
        long rsum=0;
        long lsum=0;
        for(int i=1;i<n;i++){
            rsum+=arr[i];
        }
        if(lsum==rsum){
            return 1;
        }
        lsum=arr[0];
        int k=-1;
        for(int i=1;i<n;i++){
            rsum-=arr[i];
            System.out.println("lsum="+lsum+"rsum"+rsum);
            if(lsum==rsum){
                k=i+1;
                break;
            }
            else{
                lsum+=arr[i];
            }
        }
        return k;
    }
	
	public static void rearrange(long arr[], int n) 
    { 
    	long temp[]=new long[n];
    	int k=0;
    	int i=0,j=n-1;
    	for(i=0,j=n-1;i<n/2;i++,j--) {
    		temp[k++]=arr[j];
    		temp[k++]=arr[i];
    	}
    	if(n%2!=0) {
    		temp[k]=arr[i];
    	}
    	 for(int m=0;m<n;m++) {
    		 System.out.println(temp[m]);
    	 }
    }
	
	public static void TrappingWater(int arr[],int n) {
		int prevIndex=0;
		int prev=arr[0];
		int temp=0;
		int water=0;
		for(int i=1;i<n;i++) {
			if(arr[i]>=prev) {
				prev=arr[i];
				prevIndex=i;
				temp=0;
			}
			else {
				water+=prev-arr[i];
				temp+=prev-arr[i];
			}
		}
		if(prevIndex<n-1) {
			water-=temp;
			prev=arr[n-1];
			for(int i=n-1;i>=prevIndex;i--) {
				if(arr[i]>=prev) {
					prev=arr[i];
				}
				water+=prev-arr[i];
			}
		}
		System.out.println(water);
	}
	public static void spiral(int arr[][],int n){

		for(int i=0;i<n/2;i++){
			for(int j=i;j<=n-i-1;j++){
				System.out.print(arr[i][j]+" ");
			}
			for(int j=i+1;j<=n-i-1;j++){
				System.out.print(arr[j][n-i-1]+" ");
			}
			for(int j=n-2-i;j>=i;j--){
				System.out.print(arr[n-i-1][j]+" ");
			}
			for(int j=n-2-i;j>=i+1;j--){
				System.out.print(arr[j][i]+" ");
			}
		}
	}
	
	public static void BuyAndSell(int arr[],int n) {
		int buy=0;
		int sell=0;
		for(int i=0;i<n-1;i++) {
			if(arr[i]<arr[i+1]) {
				buy=i;
			}
			if(arr[i]>arr[i+1]) {
				sell=i;
			}
		}
	}
	public static void arrange(long arr[], int n)
    {
        // your code here
        for(int i=0;i<n;i++){
            arr[i]+=(arr[(int)arr[i]]%n)*n;
        }
        for(int i=0;i<n;i++){
            arr[i]=arr[i]/n;
        }
    }
	
	public static void paintFence(int arr[][],int n){
		int red[]=new int[n];
		int blue[]=new int[n];
		int green []=new int[n];
		red[0]=arr[0][0];
		blue[0]=arr[0][1];
		green[0]=arr[0][2];
		for(int i=1;i<n;i++){
			red[i]=Math.min(blue[i-1],green[i-1])+arr[i][0];
			blue[i]=Math.min(red[i-1],green[i-1])+arr[i][1];
			green[i]=Math.min(red[i-1],blue[i-1])+arr[i][2];
		}
		System.out.println(Math.min(red[n-1],Math.min(blue[n-1],green[n-1])));

	}


	public static void sortString(String a,String b){

	}

	public static void maxIndexDiff(int arr[], int n) { 
        
        // Your code here
		int l=0;
		int m=0;
		for(int i=0;i<n;i++) {
			if(arr[i]<arr[i+1]) {
				l=i;
				break;
			}
		}
		for(int i=n-1;i>=0;i--) {
			if(arr[i]>arr[i-1]) {
				m=i;
				break;
			}
		}
        
		System.out.println(m-l);
    }
	
	public static int find(int arr[],int i,int j,int ele){
		int mid=(i+j)/2;
		System.out.println(mid);
		if(mid<i || mid >j-1){
			return -1;
		}
		if(ele==arr[mid])
		return mid;
		else{
			int left=find(arr,i,mid-1,ele);
			if(left!=-1){
				return left;
			}
			else{
				System.out.println("left returened null");
				int right=find(arr,mid+1,j,ele);
				if(right!=-1){
					return right;
				}
			}
		}
		return -1;
	}
	
	
	//if we have given tile size as 2x1 and floor size 2xn
	public static void Tiling(int n){
		int dp[]=new int[n+1];
		dp[0]=1;
		dp[1]=1;
		for(int i=2;i<=n;i++){
			dp[i]=dp[i-1]+dp[i-2];
		}
		System.out.println(dp[n]);

	}

	//if we are given tile size mx1 and floor size mxn
	public static void TilingGeneral(int m,int n){
		int dp[]=new int[n+1];
		dp[0]=1;
		dp[1]=1;
		for(int i=2;i<=n;i++){
			if(i<m){
				dp[i]=1;
			}
			else if(i==m){
				dp[i]=2;
			}
			else{
				dp[i]=dp[i-1]+dp[i-m];
			}
		}
		System.out.println(dp[n]);
	}
	

	// buy and sell question with only one transaction;
	public static void butAndSell(int n,int arr[]){
		int dp[]=new int[n];
		int min=Integer.MAX_VALUE;
		int maxProfit=Integer.MIN_VALUE;
		for(int i=0;i<n;i++){
			if(min>arr[i]){
				min=arr[i];
			}
			dp[i]=arr[i]-min;
			if(maxProfit<dp[i]){
				maxProfit=dp[i];
			}
		}
		System.out.println(maxProfit);
	}


	// buy and sell question with infinite no of transaction
	public static void butAndSell1(int n,int arr[]){
		int profit=0;
		int buy=0;
		int sell=0;
		for(int i=1;i<n;i++){
			if(arr[i-1]<arr[i]){
				sell++;
			}
			else{
				profit+=arr[sell]-arr[buy];
				buy=sell=i;
			}
			System.out.println("bus is "+buy+"sell is "+sell);
		}
		profit+=arr[sell]-arr[buy];
		System.out.println(profit);
	}


	// piyush and magical bean question;
	public static void magicalBean(int n,int m,int k,int s,char arr[][]){
		int str=s;
		for(int i=0;i<n;i++){
			System.out.println();
			for(int j=0;j<m;j++){
				System.out.print(arr[i][j]);
				if(arr[i][j]=='.'){
					str-=2;
				}
				else if(arr[i][j]=='*'){
					str+=5;
				}
				else{
					break;
				}	
				if(j+1!=m){
					str-=1;
				}
			}
		}
		if(str>k){
			System.out.println("YES");
			System.out.println(str);
		}
		else{
			System.out.println("NO");
		}
	}
	
	public static int compareTo(String s1,String s2){
		int i=0;
		while(i<s1.length() && i<s2.length()){
			if(s1.charAt(i)>s2.charAt(i)){
				return 1;
			}
			else if(s1.charAt(i)<s2.charAt(i)){
				return -1;
			}
			i++;
		}
		if(s1.length()>s2.length()){
			return 1;
		}
		else{
			return -1;
		}
	}
	public static void sortfunc(int n,String arr[]){
		for (int i = 0; i < n; i++) {

            for (int j = 0; j < n - i - 1; j++) {

                if (compareTo(arr[j], arr[j + 1]) > 0) {

                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }

            }
        }

	}
//	The stock span problem is a financial problem where we have a series of N daily price quotes for a stock and we need to calculate span of stock’s price for all N days. You are given an array of length N, where ith element of array denotes the price of a stock on ith. Find the span of stock's price on ith day, for every 1<=i<=N.
//	A span of a stock's price on a given day, i, is the maximum number of consecutive days before the (i+1)th day, for which stock's price on these days is less than or equal to that on the ith day.
	public static void stockSpan(int arr[],int n){
		int solu[]=new int[n];
		solu[0]=1;
		int max=arr[0];
		for(int i=1;i<n;i++){
			if(max<arr[i]){
				max=arr[i];
			}
			if(max<=arr[i]){
				solu[i]=i+1;
			}
			else{
				if(arr[i-1]>arr[i]){
					solu[i]=1;
				}
				else{
					solu[i]=solu[i-1]+1;
				}
			}
		}
		for(int i=0;i<n;i++){
			System.out.print(solu[i]+" ");
		}
	}
	
	//The kingsmen are back! They have N buildings built in line numbered from 1 to N.
	//Each building has a height h denoted by A[i]. The kingsmen will jump from building i to building j only if:
	public static void kingsman(int arr[],int n){
		int max=Integer.MIN_VALUE;
		int count=0;
		for(int i=0;i<n;i++){
			int midmax=Integer.MIN_VALUE;
			for(int j=i+1;j<n;j++){
				max=Math.max(arr[i],arr[j]);
				if(midmax<arr[j]){
					midmax=arr[j];
				}
				if(midmax>max || arr[i]==arr[j]){
					count++;
				}
			}
		}
		System.out.println(count*2);
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<n;i++){
			String no=sc.next().split(" ")[0];
			arr[i]=Integer.parseInt(no);
		}
		kingsman(arr, n);
	}
}
