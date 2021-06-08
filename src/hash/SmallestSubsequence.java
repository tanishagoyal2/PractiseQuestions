package hash;
import java.util.*;
public class SmallestSubsequence {

	
	public void subsequence(int list[]) {
		HashMap<Integer,ElementData> h=new HashMap<Integer,ElementData>();
		int len=list.length;
		solutionClass sol=new solutionClass();
		System.out.println(sol.element+"  "+sol.frequency+"  "+sol.length);
		for(int i=0;i<len;i++) {
			ElementData data=h.get(list[i]);
			if(data==null) {
				h.put(list[i], new ElementData(i));
				data=h.get(list[i]);
			}
			else {
				data.last=i;
				data.frequency+=1;
			}
			if(sol.frequency<data.frequency || (sol.frequency==data.frequency && sol.length>(data.last-data.start))) {
				sol.frequency=data.frequency;
				sol.element=list[i];
				sol.length=data.last-data.start+1;
			}
			System.out.println(sol.element+"  "+sol.frequency+"  "+sol.length);
		}
		int s=h.get(sol.element).start;
		int l=h.get(sol.element).last;
		for(int i=s;i<l+1;i++)
		System.out.print(list[i]);
	}
	
	public static void main(String []args) {
		SmallestSubsequence ss=new SmallestSubsequence();
		int A[] ={1, 2, 2, 3, 1};
		ss.subsequence(A);
	}
}
class solutionClass{
	int element;
	int frequency;
	int length;
	solutionClass(){
		element=Integer.MAX_VALUE;
		frequency=Integer.MIN_VALUE;
		length=Integer.MAX_VALUE;
	}
	
}

class ElementData{
	int start;
	int last;
	int frequency;
	ElementData(int s){
		start=s;
		last=s;
		frequency=1;
	}
}