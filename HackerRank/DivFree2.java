
public class DivFree2 {
public static long dfcount(int n,int K){
		
		if(n==1)return K;
		if(n==0 || (n>0&&K==0))return 0;
		long dfcount[][] = new long[n+1][K+1];
		long divCount[] = new long[n+1];
		long sum=0;
		
		for(int i=1;i<=K;i++){
			for(int j=1;j<=K;j++){
				if((i<=j)||(i%j)!=0){
					dfcount[1][i]++;
				}
			}
			sum+=dfcount[1][i];
		}
		divCount[1]=sum;
		
		for(int i=2;i<n;i++){
			sum = 0;
			for(int j=1;j<=K;j++){
				dfcount[i][j]=divCount[i-1];
				if(j>1){
					for(int k=1;k<=K;k++){
						if(j%k==0 && j!=k){
							dfcount[i][j]=dfcount[i][j]-dfcount[i-1][k];
						}
					}
				}
				sum+=dfcount[i][j];
				System.out.println(sum);
			}
			divCount[i]=sum%1000000007;
		}
		return divCount[n-1];
	}
	
	public static void main(String args[]){
		
//		System.out.println(dfcount(2, 2));
//		System.out.println(dfcount(3, 2));
//		System.out.println(dfcount(3, 3));
//		System.out.println(dfcount(1, 107));
//		System.out.println(dfcount(5, 6));
		System.out.println(dfcount(42, 23));
	}
}
