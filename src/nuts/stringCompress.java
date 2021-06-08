package nuts;

import java.util.*;

public class stringCompress {
	public static void main(String []args) {
		Scanner sc=new Scanner(System.in);
		StringBuilder string=new StringBuilder();
		System.out.println("enter a string");
		String input=sc.nextLine();
		int count=0;
		for(int i=0;i<input.length();i++) {
			count++;
			if(i+1>=input.length() || input.charAt(i) != input.charAt(i+1) ) {
				string.append(input.charAt(i));
				string.append(count);
				count=0;
			}
		}
		System.out.println(string.length()<input.length()?string:input);
	}
}
