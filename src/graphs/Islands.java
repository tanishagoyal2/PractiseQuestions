package graphs;

public class Islands {

    int m;
    int n;
    int graph[][];
    Islands(int m,int n,int grap[][]){
        this.m=m;
        this.n=n;
        this.graph=grap;
    }
    public void solve(){
        boolean visited[][]=new boolean [m][n];
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && graph[i][j]==1){
                    System.out.println(" for "+i+ " and "+j +" called");
                    solveUtil(visited,i,j);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public void solveUtil(boolean visited[][],int i,int j){
        if(i<0||i>=m || j<0 || j>=n || graph[i][j]!=1 || visited[i][j]==true){
            return ;
        }
        System.out.println(i+ " and "+j +" called");
        visited[i][j]=true; 
        System.out.println("initialized tp true");   
        solveUtil(visited, i-1, j);
        solveUtil(visited, i+1, j);
        solveUtil(visited, i, j-1);
        solveUtil(visited, i, j+1);
        solveUtil(visited, i-1, j-1);
        solveUtil(visited, i-1, j+1);
        solveUtil(visited, i+1, j-1);
        solveUtil(visited, i+1, j+1);
    }
    public static void main(String args[]){
        int graph[][]={{0,1,1,1,0,0,0},{0,0,1,1,0,1,0}};
        Islands is=new Islands(2, 7, graph);
        System.out.println("initalized");
        is.solve();
    }
    
}
