package Arrays;
import java.util.*;
public class string{
    static boolean isSubSequence(String str1, String str2,
                                 int a, int b)
    {
        if (a == 0)
            return true;
        if (b == 0)
            return false;
        if (str1.charAt(a - 1) == str2.charAt(b - 1))
            return isSubSequence(str1, str2, a - 1, b - 1);
        return isSubSequence(str1, str2, a, b - 1);
    }

    public static void primenNumbers(int l,int r){
        ArrayList<Integer> array=new ArrayList<Integer>();
        for(int i=l;i<=r;i++){
            if(checkifPrime(i)){
                array.add(i);
            }
        }
        int size=array.size();
        if(size==0){
            System.out.println(-1);
        }
        else{
            int m=array.get(0);
            int n=array.get(size-1);
            System.out.println(n-m);
        }
    }
    public static boolean checkifPrime(int n){
        boolean flag=true;
        if(n==1){
            return false;
        }
        for(int i=2;i<n;i++){
            if(n%i==0){
                flag =false;
                break;
            }
        }
        return flag;
    }
    public static void main(String args[] ) throws Exception {

    	Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int length[]=new int[n];
		int arr[][]=new int[n][1000];
		for(int i=0;i<n;i++){
			length[i]=sc.nextInt();
			for(int j=0;j<length[i];j++){
				arr[i][j]=Integer.parseInt(sc.next().split(" ")[0]);
			}
		}
   }
}