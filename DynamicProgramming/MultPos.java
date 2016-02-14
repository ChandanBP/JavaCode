package DP;

public class MultPos {

	public int computeProduct(int m,int n ){
		if(m==0)return 0;
		return n+computeProduct(m-1, n);
	}
	
	public int getResult(int m, int n){
		if(n>m){
			System.out.println();
			return computeProduct(m,n);
		}
		else{
			return computeProduct(n,m);
		}
	}
	
	public static void main(String args[]){
		MultPos obj = new MultPos();
		System.out.println(obj.getResult(20, 4));
	}
	
}
