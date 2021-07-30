package dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

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
    //leetcode LIS wiggle subsequence [1, 7, 4, 9, 2, 5] is a wiggle sequence because the differences (6, -3, 5, -7, 3)
    public static void wiggleMaxLength(int []nums){
        int k=1;
        int len=nums.length;
        int []Lis=new int[len];
        Lis[0]=nums[0];
        for(int i=1;i<len;i++){
            if(k%2!=0 ){
                if(Lis[k-1]<nums[i]){
                    Lis[k++]=nums[i];
                }
                else{
                    Lis[k-1]=nums[i];
                }
            }
            else{
                if(Lis[k-1]>nums[i]){
                    Lis[k++]=nums[i];
                }
                else{
                    Lis[k-1]=nums[i];
                }
            }
        }
        System.out.println(k);
    }
    //leetcode queue reconstruction by height
    public static void reconstructQueue(int [][]people){
        PriorityQueue<int []> pq=new PriorityQueue<>((a,b)->a[0]==b[0]?a[1]-b[1]:b[0]-a[0]);
        for(int i=0;i<people.length;i++){
            pq.add(people[i]);
        }
        List<int[]> result=new ArrayList<int[]>();
        while(!pq.isEmpty()){
            int[] e=pq.poll();
            result.add(e[1],e);
            System.out.println(e[0]+"  "+e[1]);
        }
        System.out.println(result.toArray(new int[people.length][2] ));
    }
    public static void main(String args[]){
        int n=9;
        int arr[][]={{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        reconstructQueue(arr);
    }
}

class intergerCollection{
    int count=1;
    LinkedList<Integer> lk=new LinkedList<Integer>();
}