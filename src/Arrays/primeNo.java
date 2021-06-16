package Arrays;

import java.util.Scanner;

public class primeNo {
    public static void solve(int n){
		for(int i=2;i<=n;i++){
			if(isPrime(i)){
				System.out.println(i);
			}
		}
	}
	public static  boolean isPrime(int n){
		for(int i=2;i<n;i++){
			if(n%i==0){
				return false;
			}
		}
		return true;
	}
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<n;i++){
			String no=sc.next().split(" ")[0];
			arr[i]=Integer.parseInt(no);
            System.out.println(arr[i]);
		}
		int k=sc.nextInt();
    }
}
