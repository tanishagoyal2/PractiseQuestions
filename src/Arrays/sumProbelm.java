package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class sumProbelm {
    //Write a program that, given an array A[] of n numbers and another number x, determines whether or not there exist two elements in S whose sum is exactly x. 
    public static void _2Sum(int arr[],int start,int n,int target){
        System.out.println("target is "+target);
        HashSet<Integer> hm=new HashSet<Integer>();
        for(int i=start;i<n;i++){
            if(hm.contains(target-arr[i])){
                System.out.print(target-arr[i]+"  "+arr[i]);
            }
            else{
                hm.add(arr[i]);
            }
        }
    }
    //
    public static void _3sum(int a[],int n){
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        Arrays.sort(a);
        for(int i=0;i<n-2;i++){
            if (i == 0 || a[i] > a[i - 1])
            {
                // Index of the first element in
                // remaining range.
                int start = i + 1;
       
                // Index of the last element
                int end = n - 1;
       
                // Setting our new target
                int target = -a[i];
       
                while (start < end)
                {
                    // Checking if current element
                    // is same as previous
                    if (start > i + 1
                        && a[start] == a[start - 1])
                    {
                        start++;
                        continue;
                    }
       
                    // Checking if current element is
                    // same as previous
                    if (end < n - 1
                        && a[end] == a[end + 1])
                    {
                        end--;
                        continue;
                    }
       
                    // If we found the triplets then print it
                    // and set the flag
                    if (target == a[start] + a[end])
                    {
                        List<Integer> li=new ArrayList<Integer>();
                        li.add(a[i]);
                        li.add(a[start]);
                        li.add(a[end]);
                        list.add(li);
                        start++;
                        end--;
                    }
                    
                    // If target is greater then
                    //  increment the start index
                    else if (target > (a[start] + a[end]))
                    {
                        start++;
                    }
                    
                    // If target is smaller than
                    // decrement the end index
                    else {
                        end--;
                    }
                }
            }
        }
        System.out.println(list);
    }
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int smallest=Integer.MAX_VALUE;
        int n=nums.length;
        for(int i=0;i<n-2;i++){
            int l=i+1;
            int r=n-1;
            while(l<r){
               int sum=nums[i]+nums[l]+nums[r];
                if(Math.abs(target-sum)<Math.abs(target-smallest)){
                    smallest=sum;
                }
                if(sum>target){
                    r--;
                }
                else{
                    l++;
                }
            }
        }
        return smallest;
        
    }

    public static void _3sumprob(int arr[],int n){
        for (int i = 0; i < n - 1; i++)
        {
            // Find all pairs with sum equals to
            // "-arr[i]"
            HashSet<Integer> s = new HashSet<Integer>();
            for (int j = i + 1; j < n; j++)
            {
                int x = -(arr[i] + arr[j]);
                if (s.contains(x))
                {
                    System.out.printf("%d %d %d\n", x, arr[i], arr[j]);
                }
                else
                {
                    s.add(arr[j]);
                }
            }
        }
    }
    public static void main(String args[]){
        int arr[]={-1,0,1,2,-1,-4};
        _3sum(arr, 6);
    }
    
}
