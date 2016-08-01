package Topcoder;

import java.io.IOException;

public class BearNSWE {

	public static double totalDistance(int[] a, String dir){
		
		if(a.length==1)return a[0]*2;
		int x=0,y=0;
		double res=0;
		
		for(int i=0;i<dir.length();i++){
			res+=a[i];
			if(dir.charAt(i)=='N'){
				x+=a[i];
			}
			if(dir.charAt(i)=='S'){
				x-=a[i];
			}
			if(dir.charAt(i)=='E'){
				y+=a[i];
			}
			if(dir.charAt(i)=='W'){
				y-=a[i];
			}
		}
		
		return res+Math.sqrt(x*x+y*y);
	}
	
	public static void main(String[] args)throws IOException {
		
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//int M = Integer.parseInt(br.readLine());
		
		int a1[] = {1,3,3};
		String s="NES";
		System.out.println(totalDistance(a1, s));
		
		int a2[] = {10,10,10,15,8,20,5};
		s="NEWEWWE";
		System.out.println(totalDistance(a2, s));
		
		int a3[] = {42};
		s="E";
		System.out.println(totalDistance(a3, s));
		
		int a4[] = {10,40,40};
		s="NSE";
		System.out.println(totalDistance(a4, s));
	}
}
