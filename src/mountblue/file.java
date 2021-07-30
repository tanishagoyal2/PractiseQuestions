package mountblue;
import java.math.BigInteger;
import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.*;
public class file {
    //sales by match
    public static void sockMerchant(int n,List<Integer> ar){
        HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
        for(int i:ar){
            if(hm.containsKey(i)){
                hm.put(i, hm.get(i)+1);
            }
            else{
                hm.put(i,1);
            }
        }
        int pairs=0;
        for(Map.Entry<Integer,Integer> e:hm.entrySet()){
            pairs+=(int)(e.getValue()/2);
        }
        System.out.println(pairs);
    }
    public static void breakingRecords(List<Integer> scores){
        int len=scores.size();
        obj highest=new obj(scores.get(0),0);
        obj lowest=new obj(scores.get(0),0);
        for(int i=1;i<len;i++){
            if(highest.no<scores.get(i)){
                highest.no=scores.get(i);
                highest.freq++;
            }
            if(lowest.no>scores.get(i)){
                lowest.no=scores.get(i);
                lowest.freq++;
            }
        }
        List<Integer> li=new ArrayList<Integer>();
        li.add(highest.freq);
        li.add(lowest.freq);
        System.out.println(highest.freq+" ");
    }
    public static void Kangaroo(int x1,int x2,int v1,int v2){
        if(x1<x2 && v1<v2){
            System.out.println("NO");
        }
        else if(x2<x1 && v2<v1){
            System.out.println("NO");
        }
        else if(v1== v2){
            System.out.println("NO");
        }
        else if((x2-x1)%(v2-v1)==0 ||(x1-x2)%(v1-v2)==0){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }

    }
    public static void compareTriplets(List<Integer> a, List<Integer> b) {
        // Write your code here
            int len=a.size();
            int alice=0;
            int bob=0;
            for(int i=0;i<len;i++){
                if(a.get(i)<b.get(i)){
                    bob++;
                }
                else if(a.get(i)>b.get(i)){
                    alice++;
                }
            }
            List<Integer> li=new ArrayList<Integer>();
            li.add(alice);
            li.add(bob);
        }
        public static void isValid(String s){
            boolean flag=true;
            HashMap<Character,Integer> hm=new HashMap<>();
            for(int i=0;i<s.length();i++){
                if(hm.containsKey(s.charAt(i))){
                    hm.put(s.charAt(i), hm.get(s.charAt(i))+1);
                    if(hm.get(s.charAt(i))>2 && !flag){
                        System.out.println("No");
                        return ;
                    }
                    else if(hm.get(s.charAt(i))==3){
                        hm.put(s.charAt(i), hm.get(s.charAt(i))-1);
                        flag=false;
                    }
                }
                else{
                    hm.put(s.charAt(i), 1);
                }
            }
            System.out.println("yes");
        }
        public static String gamingArray(List<Integer> arr) {
            // Write your code here
                TreeMap<Integer,Integer> tm=new TreeMap<Integer,Integer>();
                int len=arr.size();
                for(int i=0;i<len;i++){
                    tm.put(arr.get(i),i);
                }
                int index=len;
                int count=0;
                while(!tm.isEmpty()){
                    Map.Entry<Integer,Integer> map=tm.pollLastEntry();
                    if(map.getValue()<index){
                        count++;
                    }
                }   
                return count%2==0?"ANDY":"BOB";
            }
            public static void aVeryBigSum(List<Long> ar){
                long lg=0;
                for(Long i:ar){
                    lg+=i;
                }
                
            }
            public static void plusMinus(List<Integer> arr) {
                int pos=0;
                int neg=0;
                int zero=0;
                for(int i:arr){
                    if(i>0){
                        pos++;
                    }
                    else if(i<0){
                        neg++;
                    }
                    else{
                        zero++;
                    }
                }
                int size=arr.size();
                System.out.printf("%.6f ", pos /size);
                System.out.printf("%.6f ", neg/ size);
                System.out.printf("%.6f ", zero/size);
                }
                public static int birthday(List<Integer> s, int d, int m) {
                    // Write your code here
                        int windowsum=0;
                        for(int i=0;i<m;i++){
                            windowsum+=s.get(i);
                        }
                        int count=0;
                        if(windowsum==d){
                            count++;
                        }
                        for(int i=m;i<s.size();i++){
                            windowsum=windowsum-s.get(m-i)+s.get(i);
                            if(windowsum==d){
                                count++;
                            }
                        }
                        return count;
                
                    }
    public static void migratoryBirds(List<Integer> arr){
        TreeMap<Integer,Integer> tm=new TreeMap<Integer,Integer>();
        
    } 
    public static int libraryFine(int d2, int m2, int y2, int d1, int m1, int y1) {
        // Write your code here
            if (y2 > y1) {
                return 10000;
            } else if (y2 < y1 || m2 < m1 || m2 == m1 && d2 <= d1) {
                return 0;
            } else if (m1 == m2) {
                return 15 * (d2 - d1);
            } else {
                return 500 * (m2 - m1);
            }
    
        }
        public static void timeConversion(String s) {
            // Write your code here
            System.out.println("input taken");
            String str[]=s.split(":");
            int hr=Integer.parseInt(str[0]);
            int mm=Integer.parseInt(str[1]);
            int ss=Integer.parseInt(str[2].substring(0, 2));
            String stand=str[2].substring(2,4);
            System.out.println(stand);
            if(stand.equals("PM") && hr<12){
                    hr+=12;
            }
            else if(stand.equals("AM") && hr==12){
                hr=0;
                }
            System.out.printf("%02d:%02d:%02d",hr,mm,ss);
            }
    public static void caesarCipher(String s, int k) {
        // Write your code here
        String str="";
            for(int i:s.toCharArray()){
                if(i>=65 && i<=90){
                    i=((i-65)+k)%26+65;
                }
                else if(i>=97 && i<=122){
                    i=((i-97)+k)%26+97;
                }
                str+=(char)i;
                System.out.println(str);
            }
    }
            
    public static void main(String args[]){
        String s="aabbccddeefghi";
        caesarCipher("hello=Ni009-day", 2);
    }
    
}
class obj{
    int no;
    int freq;
    obj(int n,int f){
        no=n;
        freq=f;
    }
}
