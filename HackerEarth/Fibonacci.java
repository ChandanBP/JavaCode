import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonacci {

	static int[][] mult(int a[][],int b[][]){
		int c[][]=new int[a.length][b[0].length];
		for(int i=0;i<a.length;i++){
			for(int j=0;j<b[0].length;j++){
				for(int k=0;k<a[0].length;k++){
					c[i][j]+=a[i][k]*b[k][j];
				}
			}
		}
		return c;
	}
	
	static int[][] pow(int t[][],int pow){
		
		if(pow==1)return t;
		if(pow%2!=0)mult(t,pow(t,pow-1));
		int c[][]=pow(t,pow/2);
		return mult(c,c);
	}
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		String line[];
		for(int t=1;t<=T;t++){
			line=br.readLine().split(" ");
			int l=Integer.parseInt(line[0]);
			int r=Integer.parseInt(line[1]);
			
			int f1[]={0,1};
			int tr[][]={{1,1},
					    {1,0}
					   };
			
		   int re=0;
		   int s;
		   int prev=1;
		   int res=re;
		   boolean first=true;
		   for(t=l;t<=r;t++){
			   s=0;
			   if(t==1){
				   s=0;
			   }
			   else if(t==2){
				   s=1;
			   }
			   else{
				   if(first){
					   first=false;
					   tr=pow(tr, t-1);
					   for(int j=0;j<tr[0].length;j++){
							  for(int k=0;k<f1.length;k++){
								re+=tr[0][j]*f1[k];
							  }
					   }
					   prev=re;
				   }
				   else{
					   for(int i=0;i<tr.length;i++){
						   for(int j=0;j<tr[0].length;j++){
							   s+=prev*tr[i][j];
						   }
					   }
				   }
			   }
			   res+=s;
			   prev=s;
		   }
		}
	}
}
