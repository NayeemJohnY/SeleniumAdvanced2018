package guru99;

import java.util.Scanner;

public class SortString {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		String s1=sc.next();
		String s2= sc.next();
		
		char [] ch=new char [s1.length()];
		char tempchar;
		for(int k=0; k<s1.length(); k++)
		{
			ch[k]=s1.charAt(k);
			
		}
		int m=0,l;
		for(int i=0; i<s2.length(); i++)

		{
			for (int j=m;j<s1.length(); j++)
			{
				if(ch[j]==s2.charAt(i)|| ch[j]-32==s2.charAt(i)||ch[j]==s2.charAt(i)-32)
				{
					tempchar=ch[j];
					
					for(l=j;l>m;l--)
					{
						ch[l]=ch[l-1];
						ch[l-1]=tempchar;
					}
					
					m++;
					
				}
			}
		}
		
		for(int k=0; k<s1.length(); k++)
		{
			System.out.print(ch[k]);
		}
	}
}
