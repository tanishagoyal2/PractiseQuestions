package graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class ShortestPath {

    static int V;
    static LinkedList<AdjNode> adjList[];
    ShortestPath(int v){
        this.V=v;
        adjList=new LinkedList[v];
        for(int i=0;i<v;i++){
            adjList[i]=new LinkedList<AdjNode>();
        }
    }

    public void addEdge(int u,int v,int w){
        adjList[u].add(new AdjNode(v, w));
    }

    //shortest path from source to every other vertices in a directed graph
    public void findPath(int source){
        //first find the topological sort
        Stack<Integer> st=new Stack<Integer>();
        topological(st);
        int dist[]=new int[V];
        for(int i=0;i<V;i++){
            dist[i]=Integer.MAX_VALUE;
        }
        dist[source]=0;
        //for every element in satck find the distance from source;
        while(!st.isEmpty()){
            int top=st.pop();
            if(dist[top]!=Integer.MAX_VALUE){
                findDistance(top,dist);
            }
        }
        for (int i = 0; i < V; i++)
        {
            System.out.print("for "+i +" ");
            if (dist[i] == Integer.MAX_VALUE)
                System.out.print( "INF ");
            else
                System.out.print( dist[i] + " ");
        }

    }

    public void findDistance(int i,int dist[]){
        Iterator<AdjNode> it= adjList[i].listIterator();
        while(it.hasNext()){
            AdjNode top=it.next();
            dist[top.v]=Math.min(dist[top.v], dist[i]+top.weight);
        }
    }

    public void topological(Stack<Integer> st){
        boolean visited[]=new boolean [V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                topologicalUtil(i,st,visited);
            }
        }
    }
    
    public void topologicalUtil(int i,Stack<Integer>st ,boolean visited[]){
        visited[i]=true;
        Iterator<AdjNode> it=adjList[i].listIterator();
        while(it.hasNext()){
            int next=it.next().v;
            if(!visited[next]){
                topologicalUtil(next, st, visited);
            }
        }
        st.add(i);
    }
    
    public static void main(String args[]){
    ShortestPath g = new ShortestPath(6);
        g.addEdge(0, 1, 2);
        g.addEdge(0, 4, 1);
        g.addEdge(1, 2, 3);
        g.addEdge(4, 2, 2);
        g.addEdge(4, 5, 4);
        g.addEdge(2, 3, 6);
        g.addEdge(5, 3, 1);

        int s = 0;
        System.out.println("Following are shortest distances "+
                "from source " + s );
        g.findPath(s);
    }
}
class AdjNode{
    int v;
    int weight;
    AdjNode(int v,int w){
        this.v=v;
        this.weight=w;
    }
}