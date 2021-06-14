package graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BFSAlgo {
    int V;
    LinkedList<Integer> adjList[];
    BFSAlgo(int v){
        this.V=v;
        adjList=new LinkedList[v];
        for(int i=0;i<v;i++){
            adjList[i]=new LinkedList();
        }
    }

    public void addEdge(int src,int des){
        adjList[src].add(des);
        //for undirected graph
        adjList[des].add(src);
    }

    public void BFS(int source){
        boolean visited[]=new boolean[V];
        Queue<Integer> queue=new LinkedList<Integer>();
        queue.add(source);
        visited[source]=true;
        while(!queue.isEmpty()){
            int top=queue.poll();
            System.out.println(top+" ");
            Iterator<Integer> it=adjList[top].listIterator();
            while(it.hasNext()){
                int next=it.next();
                if(!visited[next]){
                    visited[next]=true;
                    queue.add(next);
                }
            }
        }
    }

    public void DFS(int source){
        boolean visited[]=new boolean [V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                DFSUtil(i,visited);
            }
        }
    }

    public void DFSUtil(int i,boolean visited[]){
        visited[i]=true;
        System.out.println(i+" ");
        Iterator<Integer> it=adjList[i].listIterator();
        while(it.hasNext()){
            int next=it.next();
            if(!visited[next]){
                DFSUtil(next, visited);
            }
        }

    }
    public static void main(String args[]){
        BFSAlgo g = new BFSAlgo(8);
		g.addEdge( 0, 1);
        g.addEdge(0, 3);
        g.addEdge(1, 2);
        g.addEdge(3, 4);
        g.addEdge(3, 7);
        g.addEdge(4, 5);
        g.addEdge(4, 6);
        g.addEdge(4, 7);
        g.addEdge(5, 6);
        g.addEdge(6, 7);
        g.DFS(0);
 

    }
    
}
class Edge{
    int src;
    int des;
    int value;
    Edge(int src,int des){
        this.src=src;
        this.des=des;
    }
}