package linkedList;
import java.util.*;
public class LinkedListClass {
	Node head;
	class Node{
		int data;
		Node next;
		Node(int d){
			data=d;
			next=null;
		}
	}
	
	class Result{
		Node tail;
		int length;
		Result(LinkedListClass.Node node,int len){
			tail=node;
			length=len;
		}
	}
	
	public Node returnHead() {
		return head;
	}
	
	public void push(int d) {
		Node newNode=new Node(d);
		newNode.next=head;
		head=newNode;
	}
	
	public void insertAfter(Node prevNode,int d) {
		if(prevNode==null) {
			System.out.println("node provided cant be null");
			return;
		}
		Node newNode=new Node(d);
		newNode.next=prevNode.next;
		prevNode.next=newNode;
	}
	
	public void append(int d) {
		Node newNode=new Node(d);
		if(head==null) {
			head=new Node(d);
			return;
		}
		Node node=head;
		while(node.next!=null) {
			node=node.next;
		}
		node.next=newNode;
		return ;
	}
	
	public void addNode(Node node) {
		Node start=head;
		if(start==null) {
			start=node;
		}
		else {
			while(start.next!=null) {
				start=start.next;
			}
			start.next=node;
		}
	} 
	
		public void printNode() {
		Node node=head;
		while(node!=null) {
			System.out.println(node.data);
			node=node.next;
		}
	}
	
	public void delete(int d) {
		Node node=head;
		if(node.data==d) {
			head=node.next;
			return;
		}
		while(node!=null) {
			if(node.next.data==d) {
				System.out.println("deleted element");
				node.next=node.next.next;
				return;
			}
			node=node.next;
		}
	}
	
	public void length() {
		Node node=head;
		int length=0;
		while(node!=null) {
			length++;
			node=node.next;
		}
		System.out.println(length);
	}
	
	public void swapNode(int x,int y) {
		Node prevx=null,currx,curry,prevy=null;
		currx=head;
		curry=head;
		while(currx!=null && currx.data!=x) {
			prevx=currx;
			currx=currx.next;
		}
		while(curry!=null && curry.data!=y) {
			prevy=curry;
			curry=curry.next;
		}
		if(currx==null||curry==null) {
			return ;
		}
		if(prevx!=null) {
			prevx.next=curry;
		}
		else
			head=curry;
		if(prevy!=null) {
			prevy.next=currx;
		}
		else
			head=currx;
		Node temp=currx.next;
		currx.next=curry.next;
		curry.next=temp;
	}
	
	public void reverse() {
		Node curr=head,prev=null,next=null;
		while(curr!=null) {
			next=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
		}
		head=prev;
	}
	
	public void merge(Node a,Node b) {
		Node tail=null;
		while(a!=null && b!=null) {
			if(a.data>=b.data) {
				if(tail==null) {
					tail=b;
					head=tail;
				}	
				else {
					tail.next=b;
					tail=tail.next;
				}
				b=b.next;
				
			}
			else {
				if(tail==null) {
					tail=a;
					head=tail;
				}
				else {
					tail.next=a;
					tail=tail.next;
				}
				a=a.next;
			}
		}
		if(a==null) {
			if(tail==null) {
				tail=b;
				head=tail;
			}
			else
				tail.next=b;
		}
		else {
			if(tail==null) {
				tail=a;
				head=tail;
			}
			else
				tail.next=a;
		
		}
	}
	
	public void detectloop() {
		Node node=head;
		HashSet<Node> h=new HashSet<Node>();
		while(node!=null) {
			if(h.contains(node)) {
				System.out.println("loop detected");
				node.next=null;
				detectloop();
				return;
			}
			h.add(node);
			node=node.next;
		}
		System.out.println("loop not found or deleted");
	}
	
	public void addTwoNos(Node a,Node b) {
		int carry=0;
		int sum=0;
		Node temp=null,node=null;
		while(a!=null || b!=null) {
			sum=carry+(a!=null?a.data:0)+(b!=null?b.data:0);
			carry=sum>=10?1:0;
			sum=sum%10;
			node=new Node(sum);
			if(head==null)
			{	
				head=node;
				temp=node;
			}
			else {
				temp.next=node;
				temp=temp.next;
				}
			
			if(a!=null)
				a=a.next;
			if(b!=null)
				b=b.next;	
		}
		if(carry>0)
			temp.next=new Node(carry);
	}
	
	public Node partition(Node node,int k) {
		Node head=null,tail=null;
		Node start=null,end=null;
		while(node!=null) {
			Node next=node.next;
			if(node.data<k) {
				if(head==null) {
					head=node;
					node.next=null;
					}
				else {
					head.next=node;
					node.next=null;
					head=head.next;
				}
			}
			else {
			if(tail==null) {
				start=node;
				tail=node;
				node.next=null;
			}
			else {
				tail.next=node;
				node.next=null;
				tail=tail.next;
				}
			}
			node=next;
		}
		head.next=start;
		return head;
		
	}
	
	public boolean palindrome(Node node) {
		Stack<Integer> st=new Stack<Integer>();
		Node slow=node;
		Node fast=node;
		while(fast!=null && fast.next!=null) {
			st.push(slow.data);
			slow=slow.next;
			fast=fast.next.next;
		}
		if(fast!=null) {
			slow=slow.next;
		}
		
		while(slow!=null) {
			int ele=st.pop().intValue();
			if(ele!=slow.data)
				return false;
			slow=slow.next;
		}
		return true;
	}
	
	public Result getlengthandtail(Node node) {
		int length=1;
		Node current=node;
		while(current.next!=null) {
			length++;
			current=current.next;
		}
		Result r=new Result(current,length);
		return r;
	}
	
	public Node intersetionNode(Node l1,Node l2) {
		Result r1=getlengthandtail(l1);
		Result r2=getlengthandtail(l2);
		System.out.println(r1.length+"  "+r1.tail.data);
		System.out.println(r2.length+"  "+r2.tail.data);
		if(r1.tail!=r2.tail) {
			System.out.println("no itersection");
			return null;
		}
		int diff=r1.length>r2.length?r1.length-r2.length:r2.length-r1.length;
		if(r1.length>r2.length) {
			int k=0;
			while(k!=diff) {
				l1=l1.next;
				k++;
			}
		}
		else {
			int k=0;
			while(k!=diff) {
				l2=l2.next;
				k++;
			}
		}
		while(l1!=null ||l2.next!=null) {
			if(l1==l2) {
				System.out.print("intersection is found");
				return l1;
			}
			l1=l1.next;
			l2=l2.next;
		}
		return l1;
	}
	
	public static void main(String [] args) {
		LinkedListClass list1=new LinkedListClass();
		LinkedListClass list2=new LinkedListClass();
		LinkedListClass list3=new LinkedListClass();
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		for(int i=0;i<n;i++) {
			list1.append(sc.nextInt());
		}
		System.out.println("enter second list length");
		n=sc.nextInt();
		for(int i=0;i<n;i++) {
			list2.append(sc.nextInt());
		}
		list2.addNode(list1.head.next.next.next);
		System.out.println("elements of list1");
		list1.printNode();
		System.out.println("second arra");
		list2.printNode();
		Node intersectingNode=list1.intersetionNode(list1.head,list2.head);
		System.out.println(intersectingNode!=null?intersectingNode.data:"none");
		sc.close();
	}
}
