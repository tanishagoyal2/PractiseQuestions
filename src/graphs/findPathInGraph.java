package graphs;

import java.util.ArrayList;
import java.util.Iterator;

public class findPathInGraph {
    int V;
    ArrayList<Integer> adjlist[];
    findPathInGraph(int v){
        this.V=v;
        adjlist=new ArrayList[v];
        for(int i=0;i<v;i++){
            adjlist[i]=new ArrayList<Integer>();
        }
    }
    public void addEdge(int u,int w){
        adjlist[u].add(w);
    }

    //find path in unweighted graph from source to destination using DFS
    //we dont prefer dfs traversal because it uses the stack meemory and sometimes shows memory error
    public void pathprint(int s,int d){
        boolean visited[]=new boolean[V];
        ArrayList<Integer> pathlist=new ArrayList<Integer>();
        pathlist.add(s);
        printAllPathsUtil(s,d,visited,pathlist);
    }

    public void printAllPathsUtil(int u,int d,boolean visited[],ArrayList<Integer> pathlist){
        if(u==d){
            System.out.println(pathlist);
            return ;
        }
        visited[u]=true;
        for(Integer i: adjlist[u]){
            if(!visited[i]){
                pathlist.add(i);
                printAllPathsUtil(i, d, visited, pathlist);
                pathlist.remove(i);
            }
        }
        visited[u]=false;
    }

    //find path from source to destination using bfs traversal
    public void findPath(int s,int d){
        
    }
    public static void main(String args[]){
        findPathInGraph g=new findPathInGraph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(2, 0);
        g.addEdge(2, 1);
        g.addEdge(1, 3);
        g.pathprint(2, 3);
    }
    
}
