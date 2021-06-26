package dynamic;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;

public class LIS {
    //Given N elements, write a program that prints the length of the longest increasing subsequence whose adjacent element difference is one. 
    public static void LIS1(int arr[],int n){
        HashMap<Integer,intergerCollection> hm=new HashMap<Integer,intergerCollection>();
        intergerCollection maxcollection=new intergerCollection();
        maxcollection.count=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(hm.containsKey(arr[i]-1)){
                intergerCollection ic=hm.get(arr[i]-1);
                ic.count++;
                ic.lk.add(arr[i]);
                hm.put(arr[i], ic);
                hm.remove(arr[i]-1);
            }
            else{
                intergerCollection ic=new intergerCollection();
                ic.lk.add(arr[i]);
                hm.put(arr[i],ic);
            }
            if(maxcollection.count<hm.get(arr[i]).count){
                maxcollection.count=hm.get(arr[i]).count;
                maxcollection.lk=hm.get(arr[i]).lk;
            }
        }
        System.out.println(maxcollection.count);
        while(!maxcollection.lk.isEmpty()){
            System.out.print(maxcollection.lk.removeFirst()+"  ");
        }
    }

    // the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}. 
    public static void LIS2(int arr[],int n){
        int lis[]=new int[n];
        Arrays.fill(lis,1);
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    lis[i]=Math.max(lis[j]+1, lis[i]);
                }
            }
        }
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < n; i++)
            if (max < lis[i])
                max = lis[i];
        System.out.println(max);
    }
    public static void main(String args[]){
        int n=9;
        int arr[]={10, 22, 9, 33, 21, 50, 41, 60, 80} ;
        LIS2(arr, n);
    }
}

class intergerCollection{
    int count=1;
    LinkedList<Integer> lk=new LinkedList<Integer>();
}