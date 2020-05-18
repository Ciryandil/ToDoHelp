/*
ID: soham.g1
LANG: JAVA
PROG: ariprog
*/
import java.io.*;
import java.util.*;

class ariprog
{
	static int m,n,c=0;
	
	public static void dfsap(int n, int arr[], int pos)throws IOException
	{
		if(pos<=2)
		{
			for(int i=arr[pos-1]+1;i<=2*m*m;i++)
			{
				if(bisquare(i)){
					//System.out.println(i+" is a bisquare");
					arr[pos]=i;
				
				dfsap(n,arr,pos+1);
				//arr[pos]=0;
				}
					
			}
		}
		
		else if(pos>2&&pos<=n)
		{
			int i=(arr[pos-1]-arr[pos-2])+arr[pos-1];
				if(bisquare(i)&&i<=2*m*m)
				{
					arr[pos]=i;
				
				dfsap(n,arr,pos+1);
				//arr[pos]=0;
					
			}
		}
		else{
			PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
				c++;
				out.println(arr[1]+" "+(arr[2]-arr[1]));
				out.close();
			
		}

	}
	public static boolean bisquare(int n)
	{
		//System.out.println(n);
		for(int i=0;i<n;i++)
		{
			int x = n - i*i;
			if(Math.sqrt((float)x)==(int)Math.sqrt(x)){
			//	System.out.println(n);
				return true;
			}
		}
		return false;
	}

	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		//System.out.println(bisquare(13)==false?"1":"0");
		 n = Integer.parseInt(br.readLine());
		 m = Integer.parseInt(br.readLine());
		 int arr[] = new int[n+1];
		
		 for(int i=1;i<=2*m*m;i++)
			{
				if(bisquare(i)){
					arr[1]=i;
				
				dfsap(n,arr,2);
				
				}
					
			}
		 if(c==0)
		 	out.println("NONE");

		 out.close();
	}
}