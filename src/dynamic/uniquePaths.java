package dynamic;

public class uniquePaths {
    public static void uniquepath1(int m,int n){
        int dp[][]=new int[m][n];
        dp[0][0]=1;
        int res=uniquepath1Util(m-1, n-1,m,n,dp);
        System.out.println(res);
    }
    public static int uniquepath1Util(int i,int j,int m,int n,int dp[][]){
        if(i<0 || i>=m || j<0 || j>=n){
            return 0;
        }
        if(i==0 || j==0){
            return 1;
        }
        if(dp[i][j]!=0){
            return dp[i][j];
        }
        else{
            dp[i][j]=uniquepath1Util(i-1,j,m,n,dp)+uniquepath1Util(i, j-1,m,n, dp);
            return dp[i][j];
        }
    }

    //find no of paths possible which is having obstacles
    public static void uniquePaths2(int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        int dp[][]=new int[m][n];
        if(grid[0][0]==1){
            System.out.println(0);
        }
        dp[0][0]=1;
        int res=uniquepath2Util(m-1, n-1,m,n,dp,grid);
        System.out.println(res);
    }
    public static int uniquepath2Util(int i,int j,int m,int n,int dp[][],int grid[][]){
        System.out.println(i+" "+j+" "+grid[i][j]);
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j]==1){
            return 0;
        }
        if(i==0 || j==0 ){
            return 1;
        }
        if(dp[i][j]!=0 && grid[i][j]!=1){
            return dp[i][j];
        }
        else{
            dp[i][j]=uniquepath2Util(i-1,j,m,n,dp,grid)+uniquepath2Util(i, j-1,m,n, dp,grid);
            return dp[i][j];
        }
    }

    //Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
    public static void minPathSum(int [][]grid){
        
    public static void main(String args[]){
        int [][]grid={{1,3,1},{1,5,1},{4,2,1}};
        minPathSum(grid);
    }
    
}
