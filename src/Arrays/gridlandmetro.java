package Arrays;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class gridlandmetro {
    public static BigInteger solve(BigInteger m,BigInteger n,List<List<Integer>> track,int k){
        if(k==0){
            return m.multiply(n);
        }
        else{
            Collections.sort(track,new Comparator<List<Integer>>(){
                public int compare(List<Integer> a,List<Integer> b){
                    if(a.get(0)==b.get(0)){
                        if(a.get(1)==b.get(1)){
                            return a.get(2)-b.get(2);
                        }
                        else{
                            return a.get(1)-b.get(1);
                        }
                    }
                    else{
                        return a.get(0)-b.get(0);
                    }
                }
            });
            BigInteger len=new BigInteger("0");
            List<Integer> oldtrack=track.get(0);
            for(int i=0;i<k;i++){
                List<Integer> consider=track.remove(i);
                //different row
                if(oldtrack.get(0)!=consider.get(0)){
                    Integer diff=consider.get(2)-consider.get(1)+1;
                    len.add(new BigInteger(diff.toString()));
                }
                //same row
                else{
                    //overlapping condition
                    if(consider.get(1)<oldtrack.get(1)){
                        Integer diff=Math.max(consider.get(1), oldtrack.get(1))-oldtrack.get(1);
                        len.add(new BigInteger(diff.toString()));
                    }
                    else{
                        Integer diff=consider.get(2)-consider.get(1)+1;
                        len.add(new BigInteger(diff.toString()));
                    }
                }
            }
        }
        
    }
    public static void main(String args[]){

    }
    
}
