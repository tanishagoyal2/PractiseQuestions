package graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    private void findpaths(List<List<Integer> > g,
                              int src, int dst, int v)
{
     
    // Create a queue which stores
    // the paths
    Queue<List<Integer> > queue = new LinkedList<>();
 
    // Path vector to store the current path
    List<Integer> path = new ArrayList<>();
    path.add(src);
    queue.offer(path);
     
    while (!queue.isEmpty())
    {
        path = queue.poll();
        int last = path.get(path.size() - 1);
 
        // If last vertex is the desired destination
        // then print the path
        if (last == dst)
        {
            printPath(path);
        }
 
        // Traverse to all the nodes connected to
        // current vertex and push new path to queue
        List<Integer> lastNode = g.get(last);
        for(int i = 0; i < lastNode.size(); i++)
        {
            if (isNotVisited(lastNode.get(i), path))
            {
                List<Integer> newpath = new ArrayList<>(path);
                newpath.add(lastNode.get(i));
                queue.offer(newpath);
            }
        }
    }
}
 
private static void printPath(List<Integer> path)
{
    int size = path.size();
    for(Integer v : path)
    {
        System.out.print(v + " ");
    }
    System.out.println();
}
 
// Utility function to check if current
// vertex is already present in path
private static boolean isNotVisited(int x,
                                    List<Integer> path)
{
    int size = path.size();
    for(int i = 0; i < size; i++)
        if (path.get(i) == x)
            return false;
             
    return true;
}
    public static void main(String args[]){
        findPathInGraph g=new findPathInGraph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(2, 0);
        g.addEdge(2, 1);
        g.addEdge(1, 3);
        g.findpaths(g, 2, 3);
    }
    
}
