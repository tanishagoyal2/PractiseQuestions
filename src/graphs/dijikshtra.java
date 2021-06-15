package graphs;

import java.util.*;
public class dijikshtra {
    
    int V;
    dijikshtra(int v){
        this.V=v;
    }
    public void solve(int s,int graph[][]){
        boolean visited[]=new boolean [V];
        int dist[]=new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[s]=0;
        for(int i=0;i<V-1;i++){
            int min=findMin(visited,dist);
            visited[min]=true;
            for(int j=0;j<V;j++){
                if(!visited[j] && graph[min][j]!=0 && dist[min]!=Integer.MAX_VALUE && dist[j]>dist[min]+graph[min][j]){
                    dist[j]=dist[min]+graph[min][j];
                }
            }
        }
        printSolution(dist);

    }
    void printSolution(int dist[])
    {
        System.out.println("Vertex \t\t Distance from Source");
        for (int i = 0; i <V; i++)
            System.out.println(i + " \t\t " + dist[i]);
    }
	
    
    public int findMin(boolean visited[],int dist[]){
        int min=Integer.MAX_VALUE;
        int index=-1;
        for(int i=0;i<V;i++){
            if(!visited[i] && dist[i]<min){
                min=dist[i];
                index=i;
            }
        }
        return index;
    }
    public static void main(String args[]){
        int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                                      { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                                      { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                                      { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                                      { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                                      { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                                      { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                                      { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                                      { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        dijikshtra t = new dijikshtra(9);
        t.solve(0,graph);
    }
    
}
