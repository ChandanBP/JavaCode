
public class MatrixSpiral {


	int A[][] = {
		       {1,2,3,4},
//		       {12,13,14,5},
//		       {11,16,15,6},
		       
		    };
	
	public void visitRow(int fromRow,int col,int toRow,int val){
		
		
		if(val==1){
			while(fromRow<=toRow){
				System.out.print(A[fromRow][col]+" ");
				fromRow = fromRow+val;
			}
		}
		if(val==-1){
			while(fromRow>=toRow){
				System.out.print(A[fromRow][col]+" ");
				fromRow = fromRow+val;
			}
		}
		
	}
	
    public void visitColumn(int row,int fromColumn,int toColumn,int val){
	
    	if(val==1){
    		while(fromColumn<=toColumn){
        		System.out.print(A[row][fromColumn]+" ");
        		fromColumn=fromColumn+val;
        	}
    	}
    	if(val==-1){
    		while(fromColumn>=toColumn){
        		System.out.print(A[row][fromColumn]+" ");
        		fromColumn=fromColumn+val;
        	}
    	}
	}
	
   
    
    
    public void printSpiralOrder(){
    	
    	int i=0,j=0;
    	int m=1;
    	int n=4;
    	
    	int k = m-1;
    	int l = n-1;
    	
    	int val=1;
    	boolean visit = true;
    	
    	while(i<=k && j<=l){
    		
    		// Print first row
    		visitColumn(i,j,l,1);
    		
    		// Print last column
    		visitRow(i+1,l,k,1);
    		
    		// Print last row
    		if((k-i)>=1)
    		visitColumn(k, l-1, j, -1);
    		
    		// Print first column
    		if((l-j)>=1)
    		visitRow(k-1,j,i+1,-1);
    		
    		i=i+1;
    		j=j+1;
    		
    		k=k-1;
    		l=l-1;
    	}
    }
	
	public static void main(String args[]){
		
		MatrixSpiral matrix = new MatrixSpiral();
		matrix.printSpiralOrder();
	}
	
}
