package graphs;
import java.util.*;
public class krushkals {
    int V;
    int E;
    Edges edges[];
    krushkals(int v,int e){
        this.V=v;
        this.E=e;
        edges=new Edges[e];
    }
    

    public static int find(Subset subset[],int u){
        if(subset[u].parent==u){
            return subset[u].parent;
        }
        return find(subset,subset[u].parent);
    }

    public static void union(Subset subset[],int x,int y){
        int xroot=find(subset,x);
        int yroot=find(subset,y);
        if(subset[xroot].rank<subset[yroot].rank){
            subset[xroot].parent=yroot;
        }
        else if(subset[xroot].rank>subset[yroot].rank){
            subset[yroot].parent=xroot;
        }
        else{
            subset[xroot].parent=yroot;
            subset[yroot].rank++;
        }
    }
    public void solve(){
        Edges result[]=new Edges[E];
        Subset subset[]=new Subset[V];
        for(int i=0;i<V;i++){
            subset[i]=new Subset(i, 0);
        }
        Arrays.sort(edges,new Comparator<Edges>(){
            public int compare(Edges a,Edges b){
                return a.w-b.w;
            }
        });
        int k=0;
        for(int i=0;i<E;i++){
            int x=find(subset,edges[i].u);
            int y=find(subset,edges[i].v);
            if(x!=y){
                result[k++]=edges[i];
                union(subset,x,y);
            }
        }
        int minimumCost = 0;
		for (int i = 0; i < k; ++i)
		{
			minimumCost += result[i].w;
		}
		System.out.println("Minimum Cost Spanning Tree "+ minimumCost);
    }
    public static void main(String args[]){
        krushkals obj=new krushkals(5, 6);
        int k=0;
        obj.edges[k++]=new Edges(1,2,5);
        obj.edges[k++]=new Edges(1,3,3);
        obj.edges[k++]=new Edges(4,1,6);
        obj.edges[k++]=new Edges(2,4,7);
        obj.edges[k++]=new Edges(3,2,4);
        obj.edges[k++]=new Edges(3,4,5);
        obj.solve();
    }
}

class Edges{
    int u;
    int v;
    int w;
    Edges(int u,int v,int w){
        this.u=u;
        this.v=v;
        this.w=w;
    }       
}
class Subset{
    int parent;
    int rank;
    Subset(int p,int r){
        this.parent=p;
        this.rank=r;
    }
}