package Arrays;

public class KpartitionEqual {
    //Check if it possible to partition in k subarrays with equal sum and continous element
    public static void equalSum(int n,int arr[],int k){
        //find the total sum of the array
        int total_sum=0;
        for(int i=0;i<n;i++){
            total_sum+=arr[i];
        }
        //check if its possible to divide into k subarray
        if(total_sum%k!=0){
            System.out.println("not possible!....");
            return;
        }
        int sum=total_sum/k;
        int ksum=0;
        int count=0;
        for(int i=0;i<n;i++){
            ksum+=arr[i];
            if(ksum==sum){
                ksum=0;
                count++;
            }
        }
        if(count==k){
            System.out.println("possible");
        }
        else{
            System.out.println("not possible");
        }
    }

    //Split the given array into K sub-arrays such that maximum sum of all sub arrays is minimum
    public static void solve(int n,int arr[],int k){
        int low=Integer.MIN_VALUE;
        int high=0;
        int answer=0;
        //lowest maximum possible value can be the largest value in array;
        //highest maximum possible value can be the whole arry sum;
        for(int i=0;i<n;i++){
            if(low<arr[i]){
                low=arr[i];
            }
            high+=arr[i];
        }
        while(low<=high){
            //find the middle element
            int mid =(low+high)/2;
            if(check(mid,arr,n,k)){
                answer=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        System.out.println(answer);
    }
    public static boolean check(int mid,int arr[],int n,int k){
        int count=0;
        int sum=0;
        for(int i=0;i<n;i++){
            if(arr[i]>mid){
                return false;
            }
            sum+=arr[i];
            if(sum>mid){
                count++;
                sum+=arr[i];
            }
        }
        count++;
        if(count<=k){
            return true;
        }
        else{
            return false;
        }
    }
    // Driver Code
    public static void main(String[] args)
    {
        int array[] = {10,20,30,40,50 };
        int n = array.length;
        int K = 3;
        solve(n,array, K);
        int prerequisites[][]=new int[5][6];
        for(int i=0;i<prerequisites.length;i++){
            addEdge(prerequisites[i][0],prerequisites[i][1]);
        }
    }
    
}