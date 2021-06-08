import java.util.*;
public class sortStack {

	
	public static void main(String []args) {
		Stack<Integer> stack=new Stack<Integer>();
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		for(int i=0;i<n;i++) {
			stack.push(sc.nextInt());
		}
		Stack<Integer> temp=sortStackusingStack(stack);
		while(!temp.isEmpty()) {
			System.out.println(temp.pop());
		}
	}
	public static Stack<Integer> sortStackusingStack(Stack<Integer> stack){
		Stack<Integer> temp=new Stack<Integer>();
		int ele,consider;
		while(!stack.isEmpty()) {
			ele=stack.pop();
			while(!temp.isEmpty()&& temp.peek()>ele) {
					stack.push(temp.pop());
			}
			temp.push(ele);
		}
		return temp;
	}
}
