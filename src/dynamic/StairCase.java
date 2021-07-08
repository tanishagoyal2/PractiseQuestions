package dynamic;

import java.util.Stack;

public class StairCase {

	
	// question contains variable jumps ie the no of jumps are not fixed.
	
	public static void stairCase(int arr[]) {
		int len=arr.length;
		int output[]=new int [len+1];
		output[len]=1;
		for(int i=len-1;i>=0;i--) {
			for(int j=1;j<=arr[i];j++) {
				if(j+i<=len) {
					output[i]+=output[j+i];
				}
			}
			System.out.println(output[i]);
		}
	}
	//find if the last stair is possible to reach or not
	public static void stairCase1(int nums[]){
		int n=nums.length;
		boolean dp[]=new boolean[n+1];
		dp[0]=true;
		for(int i=0;i<n;i++){
			if(nums[i]>0 && dp[i]){
			for(int j=i+1;j<=i+nums[i] && j<n;j++){
				dp[j]=true;
			}}
		}
		System.out.println(dp[n-1]);
	}
	
	public static void jumpGame3(int nums[],int start){
		Stack<Integer> st=new Stack<Integer>();
		boolean flag=false;
		int n=nums.length;
		boolean visited[]=new boolean[n];
		if(start>=0 && start<n){
			st.add(start);
			visited[start]=true;
		}
		while(!st.isEmpty()){
			int top=st.pop();
			if(nums[top]==0){
				flag=true;
				break;
			}
			int left=top-nums[top];
			int right=top+nums[top];
			if(left>=0 && left<n && !visited[left]){
				visited[left]=true;
				st.add(left);
			}
			if(right>=0 && right<n && !visited[right]){
				visited[right]=true;
				st.add(right);
			}
		}
		System.out.println(flag);
	}
	

	public static void jumpCase4(String s,int min,int max){
		int n=s.length();
		boolean dp[]=new boolean[n];
		dp[0]=true;
		for(int i=0;i<n-1;i++){
			if(s.charAt(i)=='0' && dp[i]){
				for(int j=i+min;j<=i+max && j<n;j++){
					if(s.charAt(j)=='0'){
						dp[j]=true;
					}
				}
			}
		}
		System.out.println(dp[n-1]);
	}
	public static void main(String args[]) throws Exception{
		int arr[]= {3,0,2,1,2};
		String s="01";
		jumpCase4(s, 2, 3);
	}
}
