package dynamic;

import java.util.ArrayList;
import java.util.List;

public class maximumArraySum {
    public static void solve(List<Integer> arr){
        int n=arr.size();
        long max=Integer.MIN_VALUE;
        long todd=0;
        long teve=0;
        long result=Integer.MIN_VALUE;
        long res=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(i%2==0){
                todd+=arr.get(i);
            }
            else{
                teve+=arr.get(i);
            }
            System.out.println("t odd "+todd+" teve "+teve);
            long odd=todd;
            long eve=teve;
            result=Math.max(result,(long)Math.pow(eve-odd,2));
            for(int j=1;j<=i;j++){
                odd-=arr.get(j-1);
                long temp=odd;
                odd=eve;
                eve=temp;
                result=Math.max(result,(long)Math.pow(eve-odd,2));
            }
            res=Math.max(res, result);
        }
        System.out.println(res);
    }
    public static void main(String args[]){
        List<Integer> arr = new ArrayList<Integer>() {{
            add(1);
            add(-1);
            add(1);
            add(-1);
            add(1);
            } };
        solve(arr);
    }
    
}
