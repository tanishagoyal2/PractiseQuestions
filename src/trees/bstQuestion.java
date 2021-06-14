package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bstQuestion {
    Node root;
    int sum=0;

    //Replace each node with the sum of all greater nodes in a given BST
    //Print level order BST.
    public void insert(int d){
        if(root==null){
            root=new Node(d);
        }
        else{
            Node current=root;
            Node prev=root;
            while(current!=null){
                prev=current;
                if(current.data<d){
                    current=current.right;
                }
                else{
                    current=current.left;
                }
            }
            if(prev.data<d){
                prev.right=new Node(d);
            }
            else{
                prev.left=new Node(d);
            }
            System.out.println("parent of "+d+"is "+prev.data);
        }
    }
    
    public void adjustSum(Node node){
        if(node==null){
            return;
        }
        adjustSum(node.right);
        sum+=node.data;
        node.data=sum-node.data;
        adjustSum(node.left);
    }

    public void BFSTraversal(){
        Node node=root;
        Queue<Node> queue=new LinkedList<Node>();
        queue.add(node);
        queue.add(null);
        while(!queue.isEmpty()){
            Node curr=queue.poll();
            if(curr==null){
                if(!queue.isEmpty()){
                    queue.add(null);
                    System.out.println();
                }
            }
            else{
                System.out.print(curr.data+ " ");

            if(curr.left!=null)
                queue.add(curr.left);

            if(curr.right!=null)
                queue.add(curr.right);
            }
        }
    }
   
    //You are given an array of integers. First of all ,
    // You have to form a binary search tree from given integers. 
    //Now you have given a range. You need to remove all nodes of the BST which are outside the given range.
    public void deleteNode(Node node,int key){
		Node curr=node;
		Node parent=null;
		while(curr!=null && curr.data!=key){
			parent=curr;
			if(curr.data<key){
				curr=curr.right;
			}
			else{
				curr=curr.left;
			}
		}
		//if node to be deleted is the leaf node
		if(curr.left==null && curr.right==null){
			if(parent.left==curr){
				parent.left=null;
			}
			else{
				parent.right=null;
			}
		}
		else if(curr.left!=null && curr.right!=null){
			//find the inorder successor
			Node successor=getMinimumKey(curr);
			int val=successor.data;
			//delete the successor node
			deleteNode(root,successor.data );
			//replace it with the deleting node
			curr.data=val;
		}
		else{
			Node child=curr.left!=null?curr.left:curr.right;
			if(curr!=root){
				if(curr==parent.left){
					parent.left=child;
				}
				else{
					parent.right=child;
				}
			}
			else{
				root=child;
			}
		}
		System.out.println("deletion completed");
	}
	
	public static Node getMinimumKey(Node curr)
    {
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }
    public void printpreorder(Node start) {
		if(start==null) {
			return;
		}
		
		System.out.print(start.data+"  ");
		printpreorder(start.left);
		printpreorder(start.right);
	}

    public static void main(String args[]){

       int n=7;
       int array[]={6,-13,14,-8,15,13,7};
       int lower=-10;
       int higher=13;
       bstQuestion bst=new bstQuestion();
            for(int j=0;j<n;j++){
                bst.insert(array[j]);
            }
            System.out.print("PREORDER : ");
            bst.printpreorder(bst.root);
            for(int j=0;j<n;j++){
                if(array[j]<lower || array[j]>higher){
                    bst.deleteNode(bst.root, array[j]);
                }
            }
            System.out.print("PREORDER : ");
            bst.printpreorder(bst.root);
    }
    
}

class Nodee{
    int data;
    Nodee left;
    Nodee right;
    Nodee(int d){
        this.data=d;
    }
}