package trees;

import java.util.Scanner;

public class sumAtKLevel {
    Node root ;
    
    public void insert(int d,int k){
        Node newNode=new Node(d,k);
        if(root==null){
            root=newNode;
        }
        else {
            Node parent=findParent(root);
            if(parent.left==null){
                parent.left=newNode;
            }
            else{
                parent.right=newNode;
            }
            System.out.println("for "+d+" parent is "+parent.data);
        }
    }

    public Node findParent(Node node){
        if(node==null || node.children==0){
            return null;
        }
        if(node.children!=0 && (node.left==null|| node.right==null)){
            return node;
        }
        else{
            Node left=findParent(node.left);
            if(left!=null){
                return left;
            }
            Node right=findParent(node.right);
            if(right!=null){
                return right;
            }
        }
        return null;
    }
    
    public Node buildTree(Node node){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt(); 
        node=new Node(n,k);
        if(k==0){
            return node;
        }
        else if(n==1){
            node.left=buildTree(node.left);
            return node;
        }
        else{
            node.left=buildTree(node.left);
            node.right=buildTree(node.right);
            return node;
        }

    }
    public void printpreorder(Node start) {
		if(start==null) {
			return;
		}
		
		System.out.print(start.data+"  ");
		printpreorder(start.left);
		printpreorder(start.right);
	}

    public int printSumAtKLevel(Node node,int k){
        if(node==null){
            return 0;
        }
        if(k==0){
            return node.data;
        }
        else{
            return printSumAtKLevel(node.left, k-1)+printSumAtKLevel(node.right, k-1);

        }
    }
    public static void main(String args[]){
        sumAtKLevel obj=new sumAtKLevel();
        obj.insert(1,2);
        obj.insert(2,2);
        obj.insert(3,0);
        obj.insert(4,0);
        obj.insert(5,2);
        obj.insert(6,0);
        obj.insert(7, 0);
        obj.printpreorder(obj.root);
        System.out.println(obj.printSumAtKLevel(obj.root, 2));

    }
    
}
class Node{
    int data;
    Node left;
    Node right;
    int children;
    Node(int d,int k){
        data=d;
        children=k;
        left=null;
        right=null;
    }
}