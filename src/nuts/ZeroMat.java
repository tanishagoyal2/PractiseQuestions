package nuts;

import java.util.Scanner;
import java.util.*;
public class ZeroMat {
	public static void main(String []args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int arr[][]=new int[n][n];
		boolean row[]=new boolean[n];
		boolean []column =new boolean [n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				int ele=sc.nextInt();
				arr[i][j]=ele;
				if(ele==0) {
					row[i]=true;
					column[j]=true;
				}
			}
		}
		//check for rows
		for(int i=0;i<n;i++) {
			if(row[i]) {
				nullifyrow(arr,i,n);
			}
			if(column[i]) {
				nullifycolumn(arr,i,n);
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++)
			System.out.print(arr[i][j]+"  ");
		}
		System.out.println("\n");
		
	}
	public static void nullifyrow(int arr[][],int row,int n){
		for(int i=0;i<n;i++) {
			arr[row][i]=0;
		}
	}
	public static void nullifycolumn(int arr[][],int column,int n) {
		for(int i=0;i<n;i++) {
			arr[i][column]=0;
		}
	}
}
