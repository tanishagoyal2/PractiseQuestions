package graphs;
import java.util.*;
public class journeytoMoon {
    int V;
    ArrayList<Integer> adjList[];

    int count=0;
    journeytoMoon(int v){
        this.V=v;
        adjList=new ArrayList[v];
        for(int i=0;i<v;i++){
            adjList[i]=new ArrayList<Integer>();
        }
    }
    public void addEdge(int u,int v){
        adjList[u].add(v);
        adjList[v].add(u);
    }
    
    public void COUNTCOMPONENETS(){
        int res=(V*(V-1))/2;
        boolean visited[]=new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                count=1;
                DFSUtil(i,visited);
                res-=(count*(count-1))/2;
            }
        }
        System.out.println(res);
    }
    public void DFSUtil(int i,boolean visited[]){
        visited[i]=true;
        Iterator<Integer> it=adjList[i].iterator();
        while(it.hasNext()){
            int next=it.next();
            if(!visited[next]){
                count+=1;
                DFSUtil(next, visited);
            }
        }
    }
    public static void main(String args[]){
        journeytoMoon obj=new journeytoMoon(4);
        obj.addEdge(0,2);
        //obj.addEdge(2,3);
        //obj.addEdge(1,4);
        obj.COUNTCOMPONENETS();
    }
}
