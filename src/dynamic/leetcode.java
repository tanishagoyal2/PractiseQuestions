package dynamic;

import java.math.BigDecimal;
import java.util.*;
public class leetcode {
    //triangle 120
    public static void traingle(List<List<Integer>> triangle){
        int m=triangle.size();
        int n=m;
        int max=Integer.MAX_VALUE;
        int dp[][]=new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            for(int j=1;j<=triangle.get(i-1).size();j++){
                    dp[i][j]=Math.min(dp[i-1][j-1], dp[i-1][j])+triangle.get(i-1).get(j-1);
                    if(i==m){
                        max=Math.min(max, dp[i][j]);
                    }
            }
        }
        System.out.println(max);
    }

    //leetcode pratition question
    static List<List<String>> ans=new ArrayList<List<String>>();
    public static void partition(String s){
        generatePairs(s,new ArrayList<String>());
        System.out.println(ans);
    }
    public static void generatePairs(String s,ArrayList<String> lis){
        if(s.length()==0){
           ans.add(new ArrayList(lis)); 
        }
        else{
            for(int i=1;i<=s.length();i++){
                if(isvalid(s,i)){
                    lis.add(s.substring(0,i));
                    generatePairs(s.substring(i), lis);
                    lis.remove(lis.size()-1);
                }
            }
        }
    }
    public static boolean isvalid(String s,int len){
        int l=0;
        int r=len-1;
        while(l<r){
            if(s.charAt(l)==s.charAt(r)){
                l++;
                r--;
            }
            else{
                return false;
            }
        }
        return true;
    }
    //leetcode house roober
    public static void rob(int nums[]){
        int n=nums.length;
        int dp[]=new int [n+1];
        dp[0]=0;
        for(int i=1;i<=n;i++){
            if(i==1){
                dp[i]=nums[i-1];
            }
            else{
                dp[i]=Math.max(dp[i-1], dp[i-2]+nums[i-1]);
            }
        }
        System.out.println(dp[n]);
    }

    //leetcode 152 maximum product subarray //not completed yet
    public static void maxProduct(int []nums){
        int max=Integer.MIN_VALUE;
        int n=nums.length;
        int dp[]=new int[n+1];
        dp[0]=1;
        for(int i=1;i<=n;i++){
            if(i==1){
                dp[i]=nums[i-1];
            }
            else{
                dp[i]=Math.max(dp[i-1]*nums[i-1], nums[i-1]);
            }
            max=Math.max(max, dp[i]);
            System.out.println(max);
        }
        System.out.println(max);
    }

    //leetcode 213 house robber 11
    public static void rob2(int []nums){
        int n=nums.length;
        int dp[]=new int[n+1];
        dp[0]=0;
        dp[1]=nums[0];
        int max=Integer.MIN_VALUE;
        for(int i=2;i<n;i++){
            dp[i]=Math.max(dp[i-1], dp[i-2]+nums[i-1]);
            max=Math.max(max, dp[i]);
        }
        dp[1]=1;
        if(n>1){
            dp[2]=nums[1];
            for(int i=3;i<=n;i++){
                dp[i]=Math.max(dp[i-1], dp[i-2]+nums[i-1]);
                max=Math.max(max, dp[i]);
            }
        }
        System.out.println(max);
    }
    //leetcode  91 decode ways
    public static void decode(String s){
        int n=s.length();
        int dp[]=new int[n+1];
        dp[0]=1;
        if(s.charAt(0)!='0'){
            dp[1]=1;
        }
        for(int i=2;i<=s.length();i++){
            int single=(s.charAt(i-1)-'0');

            int second=(s.charAt(i-2)-'0')*10+(s.charAt(i-1)-'0');
            //System.out.println(single+" "+second);
            if(single>=1){
                dp[i]+=dp[i-1];
            }
            if(second>=10 && second<=26){
                dp[i]+=dp[i-2];
            }
        }
        System.out.println(dp[n]);
    }

    //leetcode 264 ugly numbers
    public static void ugliNumber2(int n){
        int dp[]=new int[n+1];
        dp[1]=1;
        int _2s=1;
        int _3s=1;
        int _5s=1;
        int min;
        for(int i=2;i<=n;i++){
            min=Math.min(dp[_2s]*2,Math.min(dp[_3s]*3,dp[_5s]*5));
            dp[i]=min;
            if(dp[_2s]*2==min){
                _2s++;
            }
            if(dp[_3s]*3==min){
                _3s++;
            }
            if(dp[_5s]*5==min){
                _5s++;
            }
        }
        System.out.println(dp[n]);
    }

    //leetcode super ugly number
    public static void superuglynumber(int n,int []primes){
        PriorityQueue<item> pr=new PriorityQueue<item>(new Comparator<item>(){
            public int compare(item a,item b){
                return a.nextvalue-b.nextvalue;
            }
        });
        for(int i=0;i<primes.length;i++){
            pr.add(new item(primes[i],primes[i],1));
        }
        int dp[]=new int[n+1];
        dp[1]=1;
        for(int i=2;i<=n && !pr.isEmpty();i++){
            int min=pr.peek().nextvalue;
            //System.out.println("min is "+min);
            dp[i]=min;
            while(!pr.isEmpty()&& pr.peek().nextvalue==min){
                item top=pr.poll();
                //System.out.println("top is "+top.nextvalue);
                //item second=pr.poll();
                //System.out.println("top is "+second.no);
                pr.add(new item(dp[top.index+1]*top.no,top.no,top.index+1));

            }
        }
        System.out.println(dp[n]);
    }

    //leetcode 121 
    public static void stock1(int prices[]){
        int days=prices.length;
        int dp[]=new int[days];
        int buyPrize=Integer.MAX_VALUE;
        int maxProfit=Integer.MIN_VALUE;
        for(int i=0;i<days;i++){
            buyPrize=Math.min(buyPrize, prices[i]);
            dp[i]=prices[i]-buyPrize;
            maxProfit=Math.max(maxProfit, dp[i]);
        }
        System.out.println(maxProfit);
    }
    //55 merge intervals
    public static void merge(int[][] nums){
        PriorityQueue<element> pq=new PriorityQueue<element>(new Comparator<element>(){
            public int compare(element a,element b){
                return b.second-a.second;
            }
        });
        pq.add(new element(nums[0][0],nums[0][1]));
        for(int i=1;i<nums.length;i++){
            System.out.println(" size is "+pq.size());
            element top=pq.poll();
            if(top.second>=nums[i][0]){
                System.out.println("collision found");
                top.second=nums[i][1];
            }
            else{
                pq.add(new element(nums[i][0], nums[i][1]));
            }
            System.out.println(top.first+" "+top.second);
            pq.add(new element(top.first,top.second));
        }
        int merge[][]=new int[pq.size()][2];
        System.out.println(pq.size());
        for(int i=0;i<pq.size();i++){
            element top=pq.poll();
            System.out.println(top.first+"  "+top.second);
        }
    }
    public static void merge1(int [][]nums){
        int n=nums.length;
        List<int[]> lis=new ArrayList<int[]>();
        int k=1;
        Arrays.sort(nums,(a,b)->a[0]-b[0]);
        int []prev=new int[2];
        prev=nums[0];
        for(int i=1;i<n;i++){
            if(nums[i][0]<=prev[1]){
                prev[1]=nums[i][1];
            }
            else{
                lis.add(prev);
                prev=nums[i];
            }
        }
        lis.add(prev);
        lis.toArray(new int[lis.size()][]);
    }
    public void insert(int[][] intervals, int[] newInterval) {
        List<int []> lis=new ArrayList<int[]>();
        int n=intervals.length;
        int k=0;
        while(k<n && intervals[k][1]<newInterval[0]){
            lis.add(intervals[k++]);
        }
        int prev[]=new int[2];
        prev=newInterval;
        prev[1]=Math.max(intervals[k][1],prev[1]);
        while(k!=n){
            if(prev[1]>=intervals[k][0]){
                prev[1]=Math.max(intervals[k][1],prev[1]);
            }
            else{
                lis.add(prev);
                prev=intervals[k];
            }
            k++;
        }
        System.out.println(lis);
    }

    //leetcode 11 containers of water
    public static void maxArea(int []height){
        int left=0;
        int right=height.length-1;
        int maxAreaCalc=Integer.MIN_VALUE;
        while(left<right){
            int length=Math.min(height[left],height[right]);
            int width=right-left;
            maxAreaCalc=Math.max(maxAreaCalc, length*width);
            if(height[left]<height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        System.out.println(maxAreaCalc);
    }
    //leetcode 134 gas station
    public static void canCompleteCircuit(int []gas,int []cost){
        int index=-1;
        int length=gas.length;
        int petrol=0;
        int c=0;
        for(int i=0;i<length;i++){
            if(gas[i]-cost[i]>=0){
                index=i;
                petrol=gas[i];
                c=cost[i];
                System.out.println("index is "+i);
                for(int k=(i+1)%length;k!=i;k=(k+1)%length){
                    System.out.println("k="+k);
                    petrol+=gas[k]-c;
                    c=cost[k];
                    System.out.println("cost is "+c +" petrol is "+petrol);
                    if(petrol<c){
                        index=-1;
                    }
                }
                if(index!=-1 ){
                    System.out.println(index);
                    break;                    
                }
            }
            System.out.println(index);
        }
    }
    //leetcode 150 reverse polish notation
    public static void evalRPN(String []token){
        int length=token.length;
        Stack<Integer> stac=new Stack<Integer>();
        for(int i=0;i<length;i++){
            if(token[i]=="+" ||token[i]=="*" || token[i]=="/" || token[i]=="-"){
                int first=stac.pop();
                int second=stac.pop();
                if(token[i]=="+"){
                    stac.push(first+second);
                }
                else if(token[i]=="-"){
                    stac.push(second-first);
                }
                else if(token[i]=="*"){
                    stac.push(second*first);
                }
                else{
                    stac.push(second/first);
                }
            }
            else{
                stac.push(Integer.parseInt(token[i]));
            }
        }
        System.out.println(stac.pop());
    }
    //leetcode 179 largest number
    public static String largestNumber(int []nums){
            int len=nums.length;
            if(len==0){
                return "0";
            }
            int m=0;
            String []str=new String[len];
            for(int i=0;i<len;i++){
                str[i]=String.valueOf(nums[i]);
                m+=str[i].length();
            }
            Arrays.sort(str,(s2,s1)->(s2+s1).compareTo(s1+s2));
            if(str[0]=="0"){
                return "0";
            }
            String sss="";
            for(String s:str){
                sss+=s;
            }
            return sss;
        }
        //leetcode 334 increasing triplet subsequence
        public static void increasingTriplets(int []nums){

        }
        //leetcode 452 minimum no of arrows to burst baloons
        public static void findMinArrows(int [][]points){
            Arrays.sort(points,new Comparator<int []>(){
              public int compare(int[] a,int b[]){
                if(a[1]<b[1]){
                    return -1;
                }
                else if(a[1]>b[1]){
                    return 1;
                }
                else{
                    return 0;
                }
              }  
            });
            int arrows=1;
            int last[]=points[0];
            for(int i=1;i<points.length;i++){
                if(last[1]>=points[i][0]){
                    continue;
                }
                arrows++;
                last=points[i];
            }
            System.out.println(arrows);
        }
    public static List<Integer> paranthesisEvaluation(String s){
        List<Integer> li=new ArrayList<Integer>();
        int n=s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='*'|| s.charAt(i)=='-'|| s.charAt(i)=='+'){
                System.out.println(s.charAt(i));
                String leftExpression=s.substring(0, i);
                String rightExpression=s.substring(i+1, n);
                List<Integer> leftans=paranthesisEvaluation(leftExpression);
                List<Integer> rightans=paranthesisEvaluation(rightExpression);
                System.out.println(leftans);
                for(int left:leftans){
                    for(int right:rightans){
                        System.out.println(s.charAt(i));
                        if(s.charAt(i)=='*'){
                            li.add(left*right);
                        }
                        else if(s.charAt(i)=='+'){
                            li.add(left+right);
                        }
                        else {
                            li.add(left-right);
                        }
                    }
                }
            }         
        }
        if(li.size()==0){
            li.add(Integer.parseInt(s));
        }
        return li;
    }
    public static void main(String args[]){
        System.out.println(paranthesisEvaluation("2*3-4*5"));
    }
}
class element{
    int first;
    int second;
    element(int f,int s){
        first=f;
        second=s;
    }
}
class item{
    int nextvalue;
    int no;
    int index;
    item(int val,int no,int ind){
        this.nextvalue=val;
        this.no=no;
        this.index=ind;
    }
}
