public class DivFree1 {

	
	public static long dfcount(int n,int K){
		
		if(n==1)return K;
		if(n==0 || (n>0&&K==0))return 0;
		long dfcount[] = new long[K+1];
		long divCount[] = new long[3];
		long sum=0;
		
		for(int i=1;i<=K;i++){
			for(int j=1;j<=K;j++){
				if((i<=j)||(i%j)!=0){
					dfcount[i]++;
				}
			}
			sum+=dfcount[i];
		}
		divCount[1]=sum;
		
		long tempDFCount[];
		for(int i=2;i<n;i++){

			sum = 0;
			tempDFCount = new long[K+1];
			
			for(int j=1;j<=K;j++){
				
				tempDFCount[j] = divCount[1];
				
				if(j>1){
					for(int k=1;k<=K;k++){
						if(j%k==0 && j!=k){
							tempDFCount[j] = tempDFCount[j]-dfcount[k];
						}
					}
				}
				
				sum=sum+tempDFCount[j];
				
			}
			//divCount[1]=sum;
			divCount[1]=sum%1000000007;
			dfcount = tempDFCount;
		}
		return divCount[1];
	}
	
	public static void main(String args[]){
		
		int i = (int)Math.pow(2, 16);
		System.out.println(i);
//		System.out.println(dfcount(42, 23));
//		System.out.println(dfcount(50, 50));
	}
}

