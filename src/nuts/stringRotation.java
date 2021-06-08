package nuts;

import java.util.*;

public class stringRotation {

	public static void main(String []args) {
		String s1,s2;
		Scanner sc=new Scanner(System.in);
		s1=sc.nextLine();
		s2=sc.nextLine();
		if(s1.length()!=s2.length()) {
			System.out.println("not a rotataion");
			return;
		}
		if(s1==s2) {
			System.out.println("prefect");
			return;
		}
		int k=0;
		boolean y=false;
		for(int i=0;i<s1.length();i++) {
			if(s1.charAt(i)==s2.charAt(0)) {
				if(!checkSubstring(s1,s2,k)) {
					y=false;
					break;
				}
				else {
					y=true;
					break;
					}
			}
			k++;
		}
		System.out.println(y+"  "+k);
		boolean n=y?checkstring(s1,s2,k):null;
		System.out.println(n+"  "+k);
		System.out.println(n?"yea retated":"not rotated");
		sc.close();
	}
	
	public static boolean checkstring(String s1,String s2,int k) {
		for(int j=0;j<k;j++) {
			if(s1.charAt(j)!=s2.charAt(s2.length()-k+j)) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean checkSubstring(String s1,String s2,int k) {
		for(int j=0;j<s1.length()-k;j++) {
			if(s1.charAt(j+k)!=s2.charAt(j)) {
				return false;
			}
		}
		return true;
	}
}
