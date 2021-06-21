package string;

import java.util.Iterator;
import java.util.LinkedList;

public class stringCycle {
    //Find if an array of strings can be chained to form a circle
    static LinkedList<Integer> adjList[];
    static int V;
    stringCycle()
    {
        V=26;
        adjList=new LinkedList[26];
        for(int i=0;i<26;i++){
            adjList[i]=new LinkedList<Integer>();
        }
    }
    public void addEdge(int v,int w){
        adjList[v].add(w);
        System.out.println("first edge added");
        adjList[w].add(v);
        System.out.println("second edge added");
    }
    public void checkCycle(){
        int res=isEulerian();
        if(res==0){
            System.out.println("Graph is not eulerian graph");
        }
        else if(res==2){
            System.out.println("Graph contains eulerian cycle");
        }
        else{
            System.out.println("not a eulerian cycle");
        }
    }
    public static int isEulerian(){
        //check if all the non zero vertices are connected
        if(isConnected()==false){
            return 0;
        }
        //count all the vertices with degree odd
        int odd=0;
        for(int i=0;i<V;i++){
            if(adjList[i].size()%2!=0){
                odd++;
            }
        }
        if(odd>2){
            return 0;
        }
        return (odd==2)?1:2;
    }
    public static boolean isConnected(){
        boolean visited[]=new boolean[V];
        int i;
        
        //check if there exists any vertex with non zero degree
        for(i=0;i<V;i++){
            if(adjList[i].size()!=0)
            break;
        }

        //if there are no vertices with non zero degree then return true because there is no edge to traverse
        if(i==V){
            return true;
        }

        //perform the DFS traversal in graph
        DFSUtil(i,visited);

        //check if all the nonzero degree vertices are visited
        for(int v=0;v<V;v++){
            if(!visited[v] && adjList[v].size()!=0){
                return false;
            }
        }

        //otherwise return true because all the non zero degree verticesa are connected
        return true;
    }

    public static void DFSUtil(int i,boolean visited[]){
        visited[i]=true;
        Iterator<Integer> it=adjList[i].listIterator();
        while(it.hasNext()){
            int next=it.next();
            if(!visited[next]){
                DFSUtil(next, visited);
            }
        }
    }

    public static void main(String args[]){
        int n=4;
        String arr[]={"aaa", "bbb", "baa", "aab"};
        stringCycle obj=new stringCycle();
        for(int i=0;i<n;i++){
            String str=arr[i];
            int w=str.charAt(str.length()-1)-'a';
            int v=str.charAt(0)-'a';
            System.out.println("v="+v+"w="+w);
            obj.addEdge(v,w);
        }
        obj.checkCycle();
    }
}
