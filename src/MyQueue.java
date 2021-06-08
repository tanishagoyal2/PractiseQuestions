import java.util.*;

public class MyQueue {
	public static int remove(Stack<Integer> st) {
		Stack<Integer> temp=new Stack<Integer>();
		while(!st.isEmpty()) {
			temp.push(st.pop());
		}
		int ele=temp.pop();
		while(!temp.isEmpty()) {
			st.push(temp.pop());
		}
		return ele;
		
	}
	public static void main(String []args) {
		Scanner sc=new Scanner(System.in);
		Stack<Integer> st=new Stack<Integer>();
		int n=sc.nextInt();
		for(int i=0;i<n;i++) {
			st.push(sc.nextInt());
		}
		int pop=remove(st);
		System.out.println("removed element is "+pop);
	}
}
