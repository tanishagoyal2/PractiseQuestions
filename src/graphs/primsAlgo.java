package graphs;

import java.util.*;
public class primsAlgo {

    int V;
    primsAlgo(int v){
        this.V=v;
    }
    public void MST(int s,int graph[][]){
        boolean mst[]=new boolean [V];
        int parent[]=new int[V];
        int key[]=new int[V];
        Arrays.fill(key,Integer.MAX_VALUE);
        key[s]=0;
        parent[s]=-1;
        for(int i=0;i<V-1;i++){
            int minKey=findMin(key,mst);
            mst[minKey]=true;
            for(int v=0;v<V;v++){
                if( graph[minKey][v]!=0 && !mst[v] && key[v]>graph[minKey][v]){
                    key[v]=graph[minKey][v];
                    parent[v]=minKey;
                }
            }
        }
        printMST(parent,graph);

    }

    public void printMST(int parent[],int graph[][]) {
		for(int i=1;i<V;i++) {
			System.out.println(parent[i]+"  "+i+"  "+graph[i][parent[i]]);
		}
	}
    public int findMin(int key[],boolean mst[]){
        int minValue=Integer.MAX_VALUE;
        int index=-1;
        for(int i=0;i<V;i++){
            if(!mst[i] && key[i]<minValue){
                index=i;
                minValue=key[i];
            }
        }
        return index;
    }
    public static void main(String args[]){
        primsAlgo algo=new primsAlgo(5);
		int graph[][] = new int[][] { { 0, 2, 0, 6, 0 },
            { 2, 0, 3, 8, 5 },
            { 0, 3, 0, 0, 7 },
            { 6, 8, 0, 0, 9 },
            { 0, 5, 7, 9, 0 } };
		algo.MST(0,graph);
    }
    
}
