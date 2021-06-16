package graphs;

public class findPath {

    public boolean path(int grid[][]){
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    int srci=i;
                    int srcj=j;
                    return (findPathUtil(grid,i-1,j,m,n,srci,srcj)|| findPathUtil(grid,i+1,j,m,n,srci,srcj)|| findPathUtil(grid,i,j-1,m,n,srci,srcj)|| findPathUtil(grid,i,j+1,m,n,srci,srcj));
                }
            }
        }
        return false;
    }

    public boolean findPathUtil(int grid[][],int i,int j,int m, int n ,int srci,int srcj){
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j]==0 || (srci==i && srcj==j)){
            return false;
        }
        if(grid[i][j]==2){
            return true;
        }
        return (findPathUtil(grid, i+1, j, m, n, srci, srcj)|| findPathUtil(grid, i-1, j, m, n, srci, srcj)|| findPathUtil(grid, i, j-1, m, n, srci, srcj)|| findPathUtil(grid, i, j+1, m, n, srci, srcj));
    }

    public static void main(String args[]){
        int grid[][]={{3,0,3,0,0},{3,0,0,0,3}
        ,{3,3,3,3,3},{0,2,3,0,0},{3,0,0,1,3}};
        findPath obj=new findPath();
        System.out.println(obj.path(grid));

    }
    
}
