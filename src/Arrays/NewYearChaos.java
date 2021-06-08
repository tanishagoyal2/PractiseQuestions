package Arrays;
import java.util.*;
public class NewYearChaos {

	
	public void testChaos(List<Integer> list) {
		int bribes=0;
		int len=list.size();
		for(int i=len-1;i>=0;--i) {
			if(list.get(i)!=i+1) {
				if(list.get(i-1)==i+1) {
					bribes++;
					int temp=list.get(i-1);
					list.set(i-1, list.get(i));
					list.set(i, temp);
				}
				else if(list.get(i-2)==i+1) {
					bribes+=2;
					int temp=list.get(i-2);
					list.set(i-2, list.get(i-1));
					list.set(i-1, temp);
					int temp1=list.get(i-1);
					list.set(i-1, list.get(i));
					list.set(i, temp1);
				}
				else {
					System.out.println("Too chaotic");
					return;
				}
			}
			
		}
		System.out.println(bribes);
	}
	 
	
	public static void main(String args[]) {
		NewYearChaos nw=new NewYearChaos();
		List<Integer> list= new ArrayList<Integer>();
		list.add(2);
		list.add(1);
		list.add(5);
		list.add(3);
		list.add(4);
		nw.testChaos(list);
	}
}
