package Arrays;
import java.util.*;
public class ArrayQuestions {

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
	public static void main(String args[]) {
		int arr[][]={{100,5,10},{5,8,4},{3,2,9},{1,2,4}};
		paintFence(arr,4);
	}
}
