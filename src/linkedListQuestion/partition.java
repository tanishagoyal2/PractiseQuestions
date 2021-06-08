package linkedListQuestion;

import java.util.*;
import linkedList.LinkedListClass;

public class partition {
	class Node{
		int data;
		Node next;
		Node(int d){
			data=d;
			next=null;
		}
	}
	public static void main(String []args) {

		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		LinkedListClass l1=new LinkedListClass();
		System.out.println("enter elements");
		for(int i=0;i<n;i++)
		l1.append(sc.nextInt());
		System.out.println("enter an element to partiton");
		int ele=sc.nextInt();
		sc.close();
	}
}
