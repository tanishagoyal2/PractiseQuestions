package graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BFSAlgo {
    int V;
    LinkedList<Integer> adjList[];
    @SuppressWarnings("unchecked")
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

    public void topological(){
        boolean visited[]=new boolean[V];
        Stack<Integer> st=new Stack<Integer>();
        for(int i=0;i<V;i++){
            if(!visited[i]){
                topologicalUtil(i,visited,st);
            }
        }
        while(!st.isEmpty()){
            System.out.print(st.pop()+" ");
        }
    }

    public void topologicalUtil(int i,boolean visited[],Stack<Integer> st){
        visited[i]=true;
        Iterator<Integer> it=adjList[i].listIterator();
        while(it.hasNext()){
            int next=it.next();
            if(!visited[next]){
                topologicalUtil(next, visited, st);
            }
        }
        st.push(i);
    }

    //no of islands question or in simple terms no of components in a graph
    public void BFSDis(){
        boolean visited[]=new boolean[V];
        int count=0;
        for(int i=0;i<V;i++){
            if(!visited[i]){
                BFSDisUtil(i,visited);
                count++;   
            }
        }
        System.out.println(count);
    }

    public void BFSDisUtil(int i,boolean visited[]){
        visited[i]=true;
        Queue<Integer> queue=new LinkedList<Integer>();
        queue.add(i);
        while(!queue.isEmpty()){
            int top=queue.poll();
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
    
    public void shortestPathInUnweighted(int source,int des){
        int path[]=new int[V];
        int dist[]=new int[V];
        boolean visited[]=new boolean[V];
        for(int i=0;i<V;i++){
            dist[i]=Integer.MAX_VALUE;
        }
        dist[source]=0;
        visited[source]=true;
        Queue<Integer> queue =new LinkedList<Integer>();
        queue.add(source);
        while(!queue.isEmpty()){
            int top=queue.poll();
            Iterator<Integer> it=adjList[top].listIterator();
            while(it.hasNext()){
                int next=it.next();
                if(!visited[next]){
                    dist[next]=dist[top]+1;
                    path[next]=top;
                    visited[next]=true;
                    queue.add(next);
                }
            }
        }
        System.out.println(dist[des]);
    }
    public static void main(String args[]){
        BFSAlgo g = new BFSAlgo(8);
        
        boolean st=Boolean.valueOf("false");
        System.out.println(st);

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