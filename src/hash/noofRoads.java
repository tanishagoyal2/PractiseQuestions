package hash;
import java.util.*;
public class noofRoads {
    public static void solve(int n,int x,int y,int xcor[],int ycor[]){
        int count=0;
        ArrayList<Integer> arr=new ArrayList<Integer>();
        for(int i=0;i<n;i++){
            int slope=(ycor[i]-y)/(xcor[i]-x);
            if(!arr.contains(slope)){
                arr.add(slope);
                count++;
            }
        }
        System.out.println(count);
    }
        public static void main(String args[]){
            Scanner sc=new Scanner(System.in);
            int input[]=new int[3];
            int n,x,y;
            for(int i=0;i<3;i++){
                input[i]=Integer.parseInt(sc.next().split(" ")[0]);
            }
            n=input[0];
            x=input[1];
            y=input[2];
            System.out.println(n);
            int xcor[]=new int[n];
            int ycor[]=new int[n];
            for(int i=0;i<n;i++){
                for(int j=0;j<2;j++){
                    if(j==0){
                        xcor[i]=Integer.parseInt(sc.next().split(" ")[0]);
                    }
                    else{
                        ycor[i]=Integer.parseInt(sc.next().split(" ")[0]);
                    }
                }
            }
           solve(n, x, y, xcor, ycor); 
        }
}
