package trees;

import java.util.LinkedList;
import java.util.Queue;

public class bstQuestion {
    Node root;
    int sum=0;
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
    public static void main(String args[]){
        bstQuestion bst=new bstQuestion();
        bst.insert(4);
        bst.insert(2);
        bst.insert(5);
        bst.insert(3);
        bst.insert(1);
        bst.adjustSum(bst.root);
        bst.BFSTraversal();

    }
    
}
class Node{
    int data;
    Node left;
    Node right;
    Node(int d){
        this.data=d;
    }
}