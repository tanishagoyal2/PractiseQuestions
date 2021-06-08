package dynamic;
import java.util.*;
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
	
	
	
	public static void main(String args[]) throws Exception{
		int arr[]= {5,5,2,4,1,5,9,8,6,3,8,9,1};
		stairCase(arr);
	}
}
