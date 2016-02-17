// Matrix Rotation for m*n by 90 degrees
public class MatrixRotation {

	public static void main(String args[]){
		
		int m=4;
		int n=4;
		int a[][] = new int[m][n];
		int res[][] = new int[m][n];
		
		int val = 1;
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				a[i][j] = val++;
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println("Rotated");
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				res[j][n-i-1] = a[i][j];
			}
		}
		
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				System.out.print(res[i][j]+" ");
			}
			System.out.println();
		}
	}
}
