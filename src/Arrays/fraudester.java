package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class fraudester {

    public static void solve(List<Integer> arr,int n,int k){
        ArrayList<Integer> res=new ArrayList<Integer>();
        int count=0;
        for(int i=0;i<n;i++){
            if(i<k){
                res.add(arr.get(i));
            }
            else{
                Collections.sort(res);
                double median= k%2==0 ?(res.get((k/2)-1)+res.get(k/2))/2.0 :res.get(k/2);
                System.out.println("media is "+median);
                res.remove(0);
                res.add(arr.get(i));
                if(arr.get(i)>=2*median){
                    count++;
                    System.out.println("count increase  at "+arr.get(i));
                }
            }
        }
        System.out.println(count);
    }
    public static void main(String args[]){
        List<Integer> arr=new ArrayList<Integer>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(4);
        arr.add(6);
        arr.add(8);
        arr.add(4);
        arr.add(5);
        solve(arr, 5,4);
    }
    
}
