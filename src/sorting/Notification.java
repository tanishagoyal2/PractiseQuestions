package sorting;
import java.util.*;
public class Notification {

	public void getNotification(List<Integer> list,int d) {
		int len=list.size();
		int sum=0;
		int notify=0;
		for(int i=0;i<len;i++) {
			if(i<d) {
				sum+=list.get(i);
			}
			else {
				double med=d%2==0?sum/2
				sum=sum-list.get(d-i)+list.get(i);
				
			}
		}
	}
	
	public static void main(String args[]) {
		List<Integer> list=new ArrayList<Integer>();
		
	}
	
}
