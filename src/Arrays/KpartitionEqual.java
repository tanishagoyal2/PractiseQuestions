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
    public static void main(String args[]){
        int n=3;
        int arr[]={ 4, 2, 5 };
        int k=3;
        equalSum(n, arr, k);

    }
    
}